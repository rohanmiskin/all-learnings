package org.learning.all.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ReceivingConstants {

    @AllArgsConstructor
    public enum  ReceivingErrors {
        INVALID_NAME("Name is null or invalid"),
        INVALID_ID("Id is invalid")
        ;

        @Getter
        private String parameterNAme;
    }

    @AllArgsConstructor
    public enum ERROR_CODES{
        CODE_105(105,"validation failed")
        ;

        @Getter
        private int errorCode;

        @Getter
        private String description;

    }
}
