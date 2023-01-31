package org.learning.all.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParser;
import org.learning.all.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class StaticContextInitialization {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JsonParser jsonParser;

    @PostConstruct
    public void init(){
        ApplicationUtil.setObjectMapper(objectMapper);
        ApplicationUtil.setJsonParser(jsonParser);
    }
}
