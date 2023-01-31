package org.learning.all.model.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentKey {

    @JsonProperty("_id")
    String id;
}
