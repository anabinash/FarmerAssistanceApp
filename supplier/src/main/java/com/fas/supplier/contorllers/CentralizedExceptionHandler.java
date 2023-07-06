package com.fas.supplier.contorllers;

import com.fas.supplier.exceptions.*;
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

/**
 * Central Controller class exception to be thrown to REST end points
 *
 * @author singh
 */
@RestControllerAdvice
@Component
public class CentralizedExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(FarmerNotFoundException.class)
    public String handleFarmerNotFoundException(FarmerNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SupplierNotFoundException.class)
    public String handleBuyRequestNotFoundException(SupplierNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BuyRequestIdNotFoundException.class)
    public String handleBuyRequestIdNotFoundException(BuyRequestIdNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public String handleProductNotFoundException(ProductNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoBuyRequestsFoundException.class)
    public String handleNoBuyRequestsFoundException(NoBuyRequestsFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BuyRequestNotPending.class)
    public String handleBuyRequestNotPending(BuyRequestNotPending e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidUserTypeException.class)
    public String handleInvalidUserTypeException(InvalidUserTypeException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SupplierLoggedOutException.class)
    public String handleSupplierLoggedOutException(SupplierLoggedOutException e) {
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
