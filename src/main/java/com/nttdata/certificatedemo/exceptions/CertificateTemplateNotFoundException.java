package com.nttdata.certificatedemo.exceptions;

public class CertificateTemplateNotFoundException extends RuntimeException {
    public CertificateTemplateNotFoundException(String message) {
        super(message);
    }
}
