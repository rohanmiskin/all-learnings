package org.learning.all.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    public MongoClient mongoClient() {
        MongoClientOptions.Builder optionsBuilder = new MongoClientOptions.Builder();
        optionsBuilder.maxConnectionIdleTime(600000);
        String uriString = "mongodb://erere";
        MongoClientURI uri = new MongoClientURI(uriString,optionsBuilder);
        return new MongoClient(uri);
    }

    @Override
    protected String getDatabaseName() {
        String database = "dbName";
        return database;
    }

    @Bean
    @Override
    public MappingMongoConverter mappingMongoConverter() throws Exception {
        MappingMongoConverter mappingMongoConverter = super.mappingMongoConverter();
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return mappingMongoConverter();
    }

    //for two different connections strings use below code

    @Bean
    public MongoDbFactory secondaryFactory(){
        MongoClientOptions.Builder optionsBuilder = new MongoClientOptions.Builder();
        optionsBuilder.maxConnectionIdleTime(600000);
        String uriString = "mongodb://erere - of second string";
        MongoClientURI uri = new MongoClientURI(uriString,optionsBuilder);
        String dbname  = " dbname";
        return new SimpleMongoDbFactory(new MongoClient(uri),dbname);
    }

    @Bean(name = "secondaryMongoTemplate")
    public MongoTemplate secondaryMongoTemplate(){
        return new MongoTemplate(secondaryFactory());
    }
}
