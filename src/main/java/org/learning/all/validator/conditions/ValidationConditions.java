package org.learning.all.validator.conditions;

import org.learning.all.model.request.DTO;

import java.util.function.Predicate;

@SuppressWarnings("java:S3740")
public interface ValidationConditions {
    Predicate getConditions();
    String getErrorDetails(DTO t);
    Integer getApplicationErrorCode();
    String getErrorMessage();
}
