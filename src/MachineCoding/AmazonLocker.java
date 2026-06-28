package MachineCoding;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class AmazonLocker {
    private Compartment[] compartments;
    private Map<String, AccessToken> accessTokenMapping;
    private final Random random;

    public AmazonLocker(Compartment[] compartments) {
        this.compartments = compartments;
        this.accessTokenMapping = new HashMap<>();
        this.random = new Random();
    }

    public String depositPackage(CompartmentSize size) {

        Compartment compartment = getAvailableCompartment(size);
        if(compartment == null) {
            throw new RuntimeException("No availablility");
        }

        compartment.open();
        compartment.markOccupied();
    
        AccessToken accessToken = generateAccessToken(compartment);
        accessTokenMapping.put(accessToken.getCode(), accessToken);

        return "AccessToken";
    }

    public void pickup(String code) {
        if(code == null) {
            throw new RuntimeException("Invalid Code");
        }

        AccessToken accessToken = accessTokenMapping.get(code);
        if(accessToken == null) {
            throw new RuntimeException("Invalid Code");
        }

        if(accessToken.isExpired()) {
            throw new RuntimeException("Expired Code");
        }

        Compartment compartment = accessToken.getCompartment();
        compartment.open();
        clearCompartment(accessToken);
    }

    public void openExpiredCompartments() {
        for(AccessToken accessToken: accessTokenMapping.values()) {
            if(accessToken.isExpired()) {
                Compartment compartment = accessToken.getCompartment();
                compartment.open();
                clearCompartment(accessToken);
            }
        }
    }

    private Compartment getAvailableCompartment(CompartmentSize size) {
        for(Compartment compartment: compartments) {
            if(size == compartment.getSize() && !compartment.isOccupied()) return compartment;
        }
        return null;
    }

    private AccessToken generateAccessToken(Compartment compartment) {
        String code = String.format("%06d", random.nextInt(1_000_000));
        Instant expiryTime = Instant.now().plus(7, ChronoUnit.DAYS);
        return new AccessToken(expiryTime, code, compartment); 
    }

    private void clearCompartment(AccessToken accessToken) {
        Compartment compartment = accessToken.getCompartment();
        compartment.markFree();
        accessTokenMapping.remove(accessToken.getCode());
    }
}

class Compartment {
    private CompartmentSize size;
    private boolean isOccupied;
    // private boolean isActive;

    public Compartment(CompartmentSize size) {
        this.size = size;
    }

    public CompartmentSize getSize() {
        return size;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void markOccupied() {
        isOccupied = true;
    }

    public void markFree() {
        isOccupied = false;
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

    public boolean isExpired() {
        return Instant.now().isAfter(expiryTime);
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
