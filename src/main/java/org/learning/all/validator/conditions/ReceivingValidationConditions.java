package org.learning.all.validator.conditions;

import lombok.AllArgsConstructor;
import org.learning.all.model.request.DTO;
import org.learning.all.model.request.ReceivingRequestDTO;

import java.util.function.Predicate;

import static org.learning.all.constants.ReceivingConstants.*;

public class ReceivingValidationConditions {


    @AllArgsConstructor
    public enum Conditions implements ValidationConditions{
        VALIDATE_NAME(
                rs -> rs.getName()!=null && rs.getName().equals("myName"),
                ReceivingErrors.INVALID_NAME.getParameterNAme(),
                ERROR_CODES.CODE_105.getErrorCode(),
                "Name is invalid"
        ),
        VALIDATE_ID(
                rs -> rs.getId()==1,
                ReceivingErrors.INVALID_ID.getParameterNAme(),
                ERROR_CODES.CODE_105.getErrorCode(),
                "Id is invalid"
        )
        ;

        private Predicate<ReceivingRequestDTO> condition;
        private String errorDetails;
        private Integer applicationErrorCode;
        private String errorMessage;

        @Override
        public Predicate getConditions() {
            return condition;
        }

        @Override
        public String getErrorDetails(DTO t) {
            return errorDetails;
        }

        @Override
        public Integer getApplicationErrorCode() {
            return applicationErrorCode;
        }

        @Override
        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
