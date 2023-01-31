package org.learning.all.model.kafka;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestMessage {

    @JsonProperty("_id")
    String id;

    String operationType;

    @JsonProperty(required = true)
    ReceivingFullDocument fullDocument;

    NameSpace ns;

    DocumentKey documentKey;

    String updateDEscription;
}
