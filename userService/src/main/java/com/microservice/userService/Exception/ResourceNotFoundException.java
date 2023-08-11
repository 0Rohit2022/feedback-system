package com.microservice.userService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
   public  ResourceNotFoundException(String msg)
    {
        super(msg);
    }
   public  ResourceNotFoundException()
    {
        super("Sorry Resource Not Found ");
    }
}
