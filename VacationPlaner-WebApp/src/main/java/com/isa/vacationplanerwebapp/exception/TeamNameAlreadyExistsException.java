package com.isa.vacationplanerwebapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class TeamNameAlreadyExistsException extends RuntimeException {
    public TeamNameAlreadyExistsException(String message) {
        super(message);
    }
}