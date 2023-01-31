package org.learning.all.service;

import org.learning.all.exception.Error;
import org.learning.all.model.request.DTO;
import org.learning.all.model.request.ReceivingRequestDTO;
import org.learning.all.validator.ReceivingRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceivingService {

    @Autowired
    ReceivingRequestValidator receivingRequestValidator;

    public boolean getReceiving(ReceivingRequestDTO receivingRequestDTO){
        validate(receivingRequestDTO);

        //dao call

        return true;
    }

    private void validate(DTO o){
        List<Error> errors = new ArrayList<>();

        receivingRequestValidator.validate(errors,o);

        if(!errors.isEmpty()){
            //throw exception
        }
    }
}
