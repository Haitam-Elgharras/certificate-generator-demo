package com.nttdata.certificatedemo.service.services.interfaces;

import com.nttdata.certificatedemo.service.dtos.CertificateTemplateDto;

import java.util.List;

public interface ICertificateService {
    List<CertificateTemplateDto> getAllCertificates();
    CertificateTemplateDto getCertificateById(Long id);
    CertificateTemplateDto saveCertificate(CertificateTemplateDto certificate);
    CertificateTemplateDto updateCertificate(CertificateTemplateDto certificate);
    void deleteCertificate(Long id);
}
