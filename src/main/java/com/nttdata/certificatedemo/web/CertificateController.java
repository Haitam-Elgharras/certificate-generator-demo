package com.nttdata.certificatedemo.web;

import com.nttdata.certificatedemo.service.dtos.CertificateTemplateDto;
import com.nttdata.certificatedemo.service.services.interfaces.ICertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/certificates")
@CrossOrigin("*")
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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CertificateTemplateDto addCertificateTemplate(@RequestParam MultipartFile file, String templateName, @RequestParam(defaultValue = "pdf") String format) throws IOException {

        Path folderPath = Paths.get(System.getProperty("user.home"),"demo-data", "certificates");

        if(!Files.exists(folderPath))
            Files.createDirectories(folderPath);

        String fileName = UUID.randomUUID().toString();
        Path filePath = Paths.get(System.getProperty("user.home"),"demo-data", "certificates", fileName + "." + format);
        Files.copy(file.getInputStream(), filePath);

        CertificateTemplateDto certificateDto = new CertificateTemplateDto();
        certificateDto.setTemplatePath(filePath.toString());
        certificateDto.setName(templateName);

        return certificateService.saveCertificate(certificateDto);
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<Resource> getFile(@PathVariable Long id) throws IOException {
        // get path from db
        CertificateTemplateDto certificateTemplateDto = certificateService.getCertificateById(id);

        Path filePath = Paths.get(certificateTemplateDto.getTemplatePath());
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));

        String mimeType = Files.probeContentType(filePath);
        if (mimeType == null)
            mimeType = "application/octet-stream";

        System.out.println("Resource: " + resource);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
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
