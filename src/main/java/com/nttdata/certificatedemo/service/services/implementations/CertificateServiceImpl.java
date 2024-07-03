package com.nttdata.certificatedemo.service.services.implementations;

import com.nttdata.certificatedemo.dao.entities.CertificateTemplate;
import com.nttdata.certificatedemo.dao.repositories.CertificateTemplateRepository;
import com.nttdata.certificatedemo.service.dtos.CertificateTemplateDto;
import com.nttdata.certificatedemo.service.mappers.ICertificateTemplateMapper;
import com.nttdata.certificatedemo.service.services.interfaces.ICertificateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CertificateServiceImpl implements ICertificateService {
    private final CertificateTemplateRepository certificateTemplateRepository;
    private final ICertificateTemplateMapper certificateMapper;

    // do the same as in CandidateServiceImpl
    @Override
    public CertificateTemplateDto getCertificateById(Long id) {
        CertificateTemplate certificate = certificateTemplateRepository.findById(id).orElse(null);

        if (certificate == null)
            return null;

        return certificateMapper.certificateToCertificateDto(certificate);
    }

    @Override
    public List<CertificateTemplateDto> getAllCertificates() {
        List<CertificateTemplate> certificates = certificateTemplateRepository.findAll();

        return certificates.stream().map(certificateMapper::certificateToCertificateDto).collect(Collectors.toList());
    }

    @Override
    public CertificateTemplateDto saveCertificate(CertificateTemplateDto certificate) {
        CertificateTemplate certificateEntity = certificateMapper.certificateDtoToCertificate(certificate);
        CertificateTemplate savedCertificate = certificateTemplateRepository.save(certificateEntity);

        return certificateMapper.certificateToCertificateDto(savedCertificate);
    }

    @Override
    public CertificateTemplateDto updateCertificate(CertificateTemplateDto certificate) {
        CertificateTemplate certificateEntity = certificateMapper.certificateDtoToCertificate(certificate);
        CertificateTemplate updatedCertificate = certificateTemplateRepository.save(certificateEntity);

        return certificateMapper.certificateToCertificateDto(updatedCertificate);
    }

    @Override
    public void deleteCertificate(Long id) {
        if (certificateTemplateRepository.existsById(id)) {
            certificateTemplateRepository.deleteById(id);
        }
    }
}
