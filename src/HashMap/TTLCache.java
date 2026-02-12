package HashMap;

import java.util.HashMap;

public class TTLCache {

    HashMap<String, CacheBucket> ttlCacheMap = new HashMap<>();

    public boolean isExpired(CacheBucket cacheBucket) {
        return System.currentTimeMillis() > cacheBucket.expiryTime;
    }

    public String getData(String userId) {
        CacheBucket cacheBucket = ttlCacheMap.get(userId);
        if(cacheBucket == null) {
            // Make DB CALL -> receive some data
            String val = "Value";
            this.putDataInCache(userId, val, 3600000);
            return val;
        }

        if(isExpired(cacheBucket)) {
            ttlCacheMap.remove(userId);
            // Make DB CALL -> receive some data
            String val = "Value";
            this.putDataInCache(userId, val, 3600000);
            return val;
        }

        return cacheBucket.value;
    }

    public void putDataInCache(String userId, String value, long ttlMinis) {
        CacheBucket cacheBucket = new CacheBucket();
        cacheBucket.value = value;
        cacheBucket.expiryTime = System.currentTimeMillis() + ttlMinis;

        ttlCacheMap.put(userId, cacheBucket);
    }


}
