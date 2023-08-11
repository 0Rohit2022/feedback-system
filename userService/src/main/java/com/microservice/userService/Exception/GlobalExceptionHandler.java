package com.microservice.userService.Exception;



import com.microservice.userService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> HandlerResourceNotFoudnException(ResourceNotFoundException ex)
    {

        String msg = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(msg).success(true).Status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponse>(response , HttpStatus.NOT_FOUND);
    }
}
