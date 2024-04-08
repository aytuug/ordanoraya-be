package com.aytugakin.travelservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class UnavailableExternalServiceException extends RuntimeException{
    private String resourceName;
    public UnavailableExternalServiceException(String resourceName){
        super(String.format("%s Unavailable External Service", resourceName));
        this.resourceName = resourceName;
    }
}