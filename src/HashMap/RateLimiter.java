package HashMap;

import java.util.HashMap;

public class RateLimiter {
    int maxTokens = 1000;
    long timeWindow = 36000000;

    HashMap<String, RateLimiterBucket> rateLimiterBucketMap = new HashMap<>();


    public String getApiCall(String userId) {
        RateLimiterBucket rateLimiterBucket = rateLimiterBucketMap.get(userId);
        if(rateLimiterBucket == null) {
            RateLimiterBucket rateLimiterBucketData = new RateLimiterBucket();
            rateLimiterBucketData.initialCallTime = System.currentTimeMillis();
            rateLimiterBucketData.totalTokens++;
            rateLimiterBucketMap.put(userId, rateLimiterBucketData);
        } else {
            rateLimiterBucket.totalTokens++;
            if (this.isTokenExpired(rateLimiterBucket)) {
                return "Error";
            }
        }
        return "Data";
    }

    public boolean isTokenExpired(RateLimiterBucket rateLimiterBucket) {
        return rateLimiterBucket.totalTokens > maxTokens &&
                (System.currentTimeMillis() - rateLimiterBucket.initialCallTime) > timeWindow;
    }

}
