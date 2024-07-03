package com.nttdata.certificatedemo.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // hibernate annotation
@Table(name = "certificate_templates")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CertificateTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String templatePath;
}
