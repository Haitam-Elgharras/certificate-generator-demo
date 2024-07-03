package com.nttdata.certificatedemo.web;

import com.nttdata.certificatedemo.service.dtos.CertificateTemplateDto;
import com.nttdata.certificatedemo.service.services.interfaces.ICertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/certificates")
public class CertificateController {
    private final ICertificateService certificateService;

    @GetMapping
    public ResponseEntity<List<CertificateTemplateDto>> getCertificateTemplates() {
        return ResponseEntity.ok(certificateService.getAllCertificates());
    }

    @GetMapping("/{id}")
    public CertificateTemplateDto getCertificateTemplateById(@PathVariable Long id) {
        return certificateService.getCertificateById(id);
    }

    @PostMapping
    public CertificateTemplateDto addCertificateTemplate(@RequestBody CertificateTemplateDto certificateDto) {
        return certificateService.saveCertificate(certificateDto);
    }

    @PutMapping("/{id}")
    public CertificateTemplateDto updateCertificateTemplate(@PathVariable Long id, @RequestBody CertificateTemplateDto certificateDto) {
        certificateDto.setId(id);
        return certificateService.saveCertificate(certificateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCertificateTemplate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
    }

}
