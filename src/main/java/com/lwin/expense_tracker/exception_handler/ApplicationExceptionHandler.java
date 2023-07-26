package com.lwin.expense_tracker.exception_handler;


import com.lwin.expense_tracker.exceptions.TransactionNotFoundException;
import com.lwin.expense_tracker.exceptions.UnAuthorizedResourceAcessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgsException (MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(
            error -> { errorMap.put(error.getField(), error.getDefaultMessage()); }
        );
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, String> handleHttpNotReadableException (HttpMessageNotReadableException exception) {
        return this.genErrorMessage(exception);
    }


    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException.class)
    public Map<String, String> handleBadCredentialsException (BadCredentialsException exception) {
        return this.genErrorMessage(exception);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({UsernameNotFoundException.class, UnAuthorizedResourceAcessException.class})
    public Map<String, String> handleUnAuthorizedException (Exception exception) {
        return this.genErrorMessage(exception);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({TransactionNotFoundException.class})
    public Map<String, String> handleNotFoundException (Exception exception) {
        return this.genErrorMessage(exception);
    }

    private Map<String, String> genErrorMessage (Exception e) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", e.getMessage());
        return errorMap;
    }
}
