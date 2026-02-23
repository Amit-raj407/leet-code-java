package HashMap;

import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {
    int maxTokens = 1000;
    long timeWindow = 36000000; // in ms

    ConcurrentHashMap<String, RateLimiterBucket> rateLimiterBucketMap = new ConcurrentHashMap<>();

    public synchronized String getApiCall(String userId) {
        RateLimiterBucket bucket = rateLimiterBucketMap.get(userId);

        long currentTime = System.currentTimeMillis();

        if (bucket == null) {
            bucket = new RateLimiterBucket();
            bucket.initialCallTime = currentTime;
            bucket.totalTokens = 1;
            rateLimiterBucketMap.put(userId, bucket);
            return "Data";
        }

        // Reset if time window passed
        if (currentTime - bucket.initialCallTime > timeWindow) {
            bucket.totalTokens = 1;
            bucket.initialCallTime = currentTime;
            return "Data";
        }

        if (bucket.totalTokens >= maxTokens) {
            return "Error"; // rate limit exceeded
        }

        bucket.totalTokens++;
        return "Data";
    }
}