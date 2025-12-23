package com.learn.javastreams.ratelimiter;


import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class RateLimiterService {

    private static final int MAX_REQUESTS = 5;      // allowed requests
    private static final long WINDOW_SIZE = 60;     // seconds

    private final ConcurrentHashMap<String, UserRequest> store = new ConcurrentHashMap<>();

    public boolean isAllowed(String ip) {
        long now = Instant.now().getEpochSecond();

        store.putIfAbsent(ip, new UserRequest(0, now));
        UserRequest request = store.get(ip);

        synchronized (request) {
            if (now - request.windowStart >= WINDOW_SIZE) {
                request.count = 0;
                request.windowStart = now;
            }

            if (request.count < MAX_REQUESTS) {
                request.count++;
                return true;
            }
            return false;
        }
    }

    static class UserRequest {
        int count;
        long windowStart;

        UserRequest(int count, long windowStart) {
            this.count = count;
            this.windowStart = windowStart;
        }
    }
}

