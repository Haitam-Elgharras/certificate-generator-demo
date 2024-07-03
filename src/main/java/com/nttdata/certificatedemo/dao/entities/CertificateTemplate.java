package com.nttdata.certificatedemo.dao.entities;

import jakarta.persistence.*;

@Entity
public class CertificateTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String templatePath;

    public CertificateTemplate() {}

    public CertificateTemplate(String name, String templatePath) {
        this.name = name;
        this.templatePath = templatePath;
    }

}
