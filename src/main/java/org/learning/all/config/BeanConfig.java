package org.learning.all.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.JsonParser;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class BeanConfig {

    @Bean
    public ObjectMapper getObjectMApper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    @Bean
    public JsonParser getJsonParser(){
        return new JsonParser();
    }


    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setAmbiguityIgnored(true).setPropertyCondition(Conditions.isNotNull());

        return modelMapper;
    }

    @Bean("customKafkaPropsBean")
    @ConfigurationProperties(prefix = "kafka.custom.properties.props")
    public Map<String,String> kafkaCustomConfiguration(){
        return new HashMap<>();
    }

    @Bean("kafkaPropertiesBean")
    public KafkaProducer<String,String> kafkaProducerBean(@Qualifier("customKafkaPropsBean") Map<String,String> kafkaProps){
        Properties properties = new Properties();
        properties.putAll(kafkaProps);
        return new KafkaProducer<>(properties);
    }


}
