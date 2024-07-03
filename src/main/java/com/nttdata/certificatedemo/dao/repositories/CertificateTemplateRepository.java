package com.nttdata.certificatedemo.dao.repositories;

import com.nttdata.certificatedemo.dao.entities.CertificateTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateTemplateRepository extends JpaRepository<CertificateTemplate, Long>{
}