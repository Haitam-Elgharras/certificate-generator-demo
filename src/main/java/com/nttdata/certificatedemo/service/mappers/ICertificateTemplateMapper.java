package com.nttdata.certificatedemo.service.mappers;

import com.nttdata.certificatedemo.dao.entities.CertificateTemplate;
import com.nttdata.certificatedemo.service.dtos.CertificateTemplateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICertificateTemplateMapper {
    CertificateTemplate certificateDtoToCertificate(CertificateTemplateDto templateDto);
    CertificateTemplateDto certificateToCertificateDto(CertificateTemplate template);
}
