package com.nttdata.certificatedemo;

import com.nttdata.certificatedemo.dao.entities.Candidate;
import com.nttdata.certificatedemo.dao.entities.CertificateTemplate;
import com.nttdata.certificatedemo.dao.repositories.CandidateRepository;
import com.nttdata.certificatedemo.dao.repositories.CertificateTemplateRepository;
import com.nttdata.certificatedemo.service.dtos.CandidateDto;
import com.nttdata.certificatedemo.service.dtos.CertificateTemplateDto;
import com.nttdata.certificatedemo.service.services.implementations.CandidateServiceImpl;
import com.nttdata.certificatedemo.service.services.implementations.CertificateServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CertificateDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CertificateDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(CandidateServiceImpl candidateService, CertificateServiceImpl certificateService) {
        return (args) -> {
            // Create some Candidate entities
            CandidateDto candidate1 = new CandidateDto();
            candidate1.setName("John Doe");
            candidate1.setScore(90);
            candidate1.setDateNaissance(new Date());

            CandidateDto candidate2 = new CandidateDto();
            candidate2.setName("Jane Doe");
            candidate2.setScore(80);
            candidate2.setDateNaissance(new Date());

            candidateService.saveCandidate(candidate1);
            candidateService.saveCandidate(candidate2);

            // Create some CertificateTemplate entities
            CertificateTemplateDto certificate1 = new CertificateTemplateDto();
            certificate1.setName("Java Certificate");
            certificate1.setTemplatePath("java_certificate_template");

            var certificate2 = new CertificateTemplateDto();
            certificate2.setName("Python Certificate");
            certificate2.setTemplatePath("python_certificate_template");

            certificateService.saveCertificate(certificate1);
            certificateService.saveCertificate(certificate2);



            // print all candidates
            System.out.println("####################");
            System.out.println(" All Candidates");
            System.out.println("####################");
            candidateService.getAllCandidates().forEach(System.out::println);


            // print all certificates
            System.out.println("####################");
            System.out.println(" All Certificates");
            System.out.println("####################");
            certificateService.getAllCertificates().forEach(System.out::println);


            // print a candidate by id
            System.out.println("####################");
            System.out.println(" Candidate by id");
            System.out.println("####################");
            System.out.println(candidateService.getCandidateById(1L));

            // print a certificate by id
            System.out.println("####################");
            System.out.println(" Certificate by id");
            System.out.println("####################");
            System.out.println(certificateService.getCertificateById(1L));

        };

    }

}
