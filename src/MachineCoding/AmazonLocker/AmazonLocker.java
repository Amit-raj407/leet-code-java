package MachineCoding.AmazonLocker;

import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import MachineCoding.AmazonLocker.Exceptions.ExpiredAccessCodeException;
import MachineCoding.AmazonLocker.Exceptions.InvalidAccessCodeException;
import MachineCoding.AmazonLocker.Exceptions.LockerUnavailableException;


public class AmazonLocker {
    private Map<CompartmentSize, Queue<Compartment>> availableCompartments;
    private Map<String, AccessToken> accessTokenMapping;
    private final Random random;
    private final Clock clock;

    private static final long ACCESS_TOKEN_EXPIRY_DAYS = 7;

    public AmazonLocker(Compartment[] compartments, Clock clock) {
        this.accessTokenMapping = new HashMap<>();
        this.random = new Random();
        this.clock = clock;

        this.availableCompartments = new HashMap<>();

        for (CompartmentSize size : CompartmentSize.values()) {
            availableCompartments.put(size, new LinkedList<>());
        }

        for (Compartment compartment : compartments) {
            availableCompartments
                .get(compartment.getSize())
                .offer(compartment);
        }
    }

    public String depositPackage(CompartmentSize size) {

        Compartment compartment = getAvailableCompartment(size);
        if(compartment == null) {
            throw new LockerUnavailableException();
        }

        compartment.open();
    
        AccessToken accessToken = generateAccessToken(compartment);
        accessTokenMapping.put(accessToken.getCode(), accessToken);

        return accessToken.getCode();
    }

    public void pickup(String code) {
        
        validateAccessCode(code);

        AccessToken accessToken = getAccessToken(code);

        if(accessToken.isExpired(clock)) {
            throw new ExpiredAccessCodeException();
        }

        Compartment compartment = accessToken.getCompartment();
        compartment.open();
        releaseCompartment(compartment);
        accessTokenMapping.remove(accessToken.getCode());
    }

    public void openExpiredCompartments() {
        Iterator<AccessToken> accessTokenIterator = accessTokenMapping.values().iterator();
        while(accessTokenIterator.hasNext()) {
            AccessToken accessToken = accessTokenIterator.next();
            if(accessToken.isExpired(clock)) {
                Compartment compartment = accessToken.getCompartment();
                compartment.open();
                releaseCompartment(compartment);
                accessTokenIterator.remove();
            }
        }

        // ConcurrentModificationException, trying to remove the iterator inside clearCompartment
        // for(AccessToken accessToken: accessTokenMapping.values()) {
        //     if(accessToken.isExpired()) {
        //         Compartment compartment = accessToken.getCompartment();
        //         compartment.open();
        //         clearCompartment(accessToken);
        //     }
        // }
    }

    private void releaseCompartment(Compartment compartment) {
        availableCompartments
                .get(compartment.getSize())
                .offer(compartment);
    }

    private void validateAccessCode(String code) {
        if(code == null || code.isBlank()) {
            throw new InvalidAccessCodeException();
        }
    }

    private AccessToken getAccessToken(String code) {
        AccessToken accessToken = accessTokenMapping.get(code);
        if(accessToken == null) {
            throw new InvalidAccessCodeException();
        }
        return accessToken;
    }

    private Compartment getAvailableCompartment(CompartmentSize size) {
        // for(Compartment compartment: compartments) {
        //     if(size == compartment.getSize() && !compartment.isOccupied()) return compartment;
        // }
        // return null;

        Queue<Compartment> compartmentQueue = availableCompartments.get(size);
        return compartmentQueue.poll();
    }

    private AccessToken generateAccessToken(Compartment compartment) {
        String code = generateUniqueCode();
        Instant expiryTime = Instant.now(clock).plus(ACCESS_TOKEN_EXPIRY_DAYS, ChronoUnit.DAYS);
        return new AccessToken(expiryTime, code, compartment); 
    }

    private String generateUniqueCode() {
        String code;
        do{
            long value = System.currentTimeMillis() + random.nextInt(1_000_000);
            code = String.format("%06d", Math.abs(value % 1_000_000)); 
        } while (accessTokenMapping.containsKey(code));

        return code;
    }
}

class Compartment {
    private CompartmentSize size;
    // private boolean isActive;

    public Compartment(CompartmentSize size) {
        this.size = size;
    }

    public CompartmentSize getSize() {
        return size;
    }

    public void open() {

    }


}

class AccessToken {
    private Instant expiryTime;
    private String code;
    private Compartment compartment;

    public AccessToken(Instant expiryTime, String code, Compartment compartment) {
        this.expiryTime = expiryTime;
        this.code = code;
        this.compartment = compartment;
    }

    public boolean isExpired(Clock clock) {
        return Instant.now(clock).isAfter(expiryTime);
    }

    public Compartment getCompartment() {
        return compartment;
    }

    public String getCode() {
        return code;
    }
}

enum CompartmentSize {
    SMALL,
    MEDIUM,
    LARGE
}
