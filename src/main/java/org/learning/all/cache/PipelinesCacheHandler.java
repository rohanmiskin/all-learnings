package org.learning.all.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.cache.Cache;
import javax.cache.CacheManager;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class PipelinesCacheHandler {

    @Autowired
    CacheManager cacheManager;

    @EventListener(classes = ApplicationStartedEvent.class)
    public void cachePipelineTableBasedObjectId(){
        List<Integer> pipelines = new ArrayList<>();//dao.findAll();
        Cache<SimpleKey,Integer> cache = cacheManager.getCache("pipelines");
        pipelines.forEach(i -> cache.put(new SimpleKey(i,i),i));

    }
}
