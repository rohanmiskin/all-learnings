package org.learning.all.model.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReceivingFullDocument {

    @Id@JsonProperty(value = "_id",required = true)
    private String id;

    @NotEmpty
    @JsonProperty("partitionKey")
    private String partitionKey;
}
