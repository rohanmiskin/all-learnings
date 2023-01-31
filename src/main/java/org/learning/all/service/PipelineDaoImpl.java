package org.learning.all.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class PipelineDaoImpl {

    @Cacheable(value = "pipelines",key = " new org.springframework.cache.interceptor.SimpleKey(#objectCode,#countryCode)")
    public Integer getPipelineId(String objectCode,String countryCode){
        Integer pipelineId = null;//function call to get pipelineId
        return pipelineId;
    }
}
