package org.learning.all.validator;

import lombok.extern.slf4j.Slf4j;
import org.learning.all.exception.Error;
import org.learning.all.model.request.DTO;
import org.learning.all.validator.conditions.ValidationConditions;
import org.learning.all.validator.factory.ValidationConditionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ReceivingRequestValidator {

    @Autowired
    ValidationConditionFactory validationConditionFactory;

    public void validate(List<Error> errors, DTO o){
        StringBuilder stringBuilder = new StringBuilder();

        validationConditionFactory.getConditionsSet(o).parallelStream().forEach(condition -> {
            if(!condition.getConditions().test(o)){
                addError(errors,condition,o);
                log.error(condition.getErrorDetails(o));
            }
        });
    }



    private static void addError(List<Error>errors, ValidationConditions conditions,DTO o){
        Error error = new Error();

        error.setMessage(conditions.getErrorMessage());
        error.setDetails(conditions.getErrorDetails(o));
        error.setErrorCode(conditions.getApplicationErrorCode());
        errors.add(error);
    }
}
