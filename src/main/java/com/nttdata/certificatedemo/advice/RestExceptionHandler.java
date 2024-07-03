package com.nttdata.certificatedemo.advice;

import com.nttdata.certificatedemo.exceptions.CandidateNotFoundException;
import com.nttdata.certificatedemo.exceptions.CertificateTemplateNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CandidateNotFoundException.class)
    public ResponseEntity<Object> handleCandidateNotFoundException(HttpServletRequest req, CandidateNotFoundException ex){
        return handleNotFoundException(req, ex);
    }

    @ExceptionHandler(CertificateTemplateNotFoundException.class)
    public ResponseEntity<Object> handleCertificateTemplateNotFoundException(HttpServletRequest req, CertificateTemplateNotFoundException ex){
        return handleNotFoundException(req, ex);
    }

    private ResponseEntity<Object> handleNotFoundException(HttpServletRequest req, Exception ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND);
        response.setMessage(ex.getMessage() + " " + req.getRequestURI());
        return buildResponseEntity(response);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }
}
