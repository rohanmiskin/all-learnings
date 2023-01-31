package org.learning.all.validator.factory;

import org.learning.all.model.request.DTO;
import org.learning.all.model.request.ReceivingRequestDTO;
import org.learning.all.validator.conditions.ReceivingValidationConditions;
import org.learning.all.validator.conditions.ValidationConditions;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

@Component
public class ValidationConditionFactory {

    public Set<? extends ValidationConditions> getConditionsSet(DTO o){
        if(o instanceof ReceivingRequestDTO){
            return EnumSet.allOf(ReceivingValidationConditions.Conditions.class);
        }
        return Collections.emptySet();
    }
}
