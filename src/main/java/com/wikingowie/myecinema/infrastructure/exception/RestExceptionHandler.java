package com.wikingowie.myecinema.infrastructure.exception;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.wikingowie.myecinema.domain.booking.BookingNotFoundException;
import com.wikingowie.myecinema.infrastructure.email.exception.EmailServiceException;
import com.wikingowie.myecinema.infrastructure.exception.ErrorModel.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import java.io.IOException;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = "Malformed JSON request" ;
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, message, ex));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage("Validation error");
        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
        return buildResponseEntity(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, ex.getParameterName() + " parameter is missing", ex));
    }

    @ExceptionHandler({UsernameNotFoundException.class, EntityNotFoundException.class,
            BookingNotFoundException.class, IllegalArgumentException.class})
    protected ResponseEntity<Object> handleNotFoundException(
            UsernameNotFoundException ex){

        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), ex));
    }

    @ExceptionHandler({ GeoIp2Exception.class, EmailServiceException.class,
            ServletException.class, RuntimeException.class,
            Exception.class, IOException.class})
    protected ResponseEntity<Object> handleException(
            Exception ex){

        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex));
    }

    @ExceptionHandler(MessagingException.class)
    protected ResponseEntity<Object> handleMessagingException(
            MessagingException ex){

        String message = ex.getMessage()+">> next exception is: "+ex.getNextException().getMessage();
        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, message , ex));
    }

    //todo - auth failure handler ?
    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity<Object> handleAuthenticationException(
            AuthenticationException ex){

        return buildResponseEntity(new ApiError(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex));
    }

    @ExceptionHandler( AccessDeniedException.class )
    protected ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {

        return buildResponseEntity(new ApiError(HttpStatus.FORBIDDEN, "Access Denied: "+ ex.getMessage(), ex));
    }


    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<Object>(apiError, apiError.getStatus());
    }
}
