package org.learning.all.model.kafka;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NameSpace {

    @JsonProperty("db")
    String database;

    @JsonProperty("coll")
    String collection;
}
