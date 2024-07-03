package com.nttdata.certificatedemo.service.dtos;

import lombok.Data;

@Data
public class CertificateTemplateDto {
    private Long id;
    private String name;
    private String templatePath;
}
