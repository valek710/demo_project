package com.example.demo_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static java.util.concurrent.TimeUnit.SECONDS;

@Service
@EnableScheduling
public class CacheService {

    @Autowired
    CacheManager cacheManager;

    public void evictAllCaches() {
        cacheManager.getCacheNames()
          .forEach(cacheName -> {
              var cache = cacheManager.getCache(cacheName);
              if (cache != null) cache.clear();
          });
    }

    @Scheduled(fixedDelay = 30, timeUnit = SECONDS)
    public void evictAllCachesAtIntervals() {
        evictAllCaches();
    }

}