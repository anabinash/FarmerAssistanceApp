package com.fas.farmer.controller;

import com.fas.farmer.exceptions.BuyRequestNotFoundException;
import com.fas.farmer.exceptions.FarmerLoggedOutException;
import com.fas.farmer.exceptions.FarmerNotFoundException;
import com.fas.farmer.exceptions.ProductNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ConstraintViolationException;
import java.net.UnknownHostException;
import java.util.stream.Collectors;

@RestControllerAdvice
@Component
public class CentralExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(FarmerNotFoundException.class)
    public String handleFarmerNotFoundException(FarmerNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BuyRequestNotFoundException.class)
    public String handleBuyRequestNotFoundException(BuyRequestNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public String handleProductNotFoundException(ProductNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FarmerLoggedOutException.class)
    public String handleFarmerLoggedOutException(FarmerLoggedOutException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class, UnknownHostException.class, HttpClientErrorException.class})
    public String handleInvalid(Exception e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", "));
    }
}

