package com.nttdata.certificatedemo.web;

import com.nttdata.certificatedemo.service.dtos.CandidateDto;
import com.nttdata.certificatedemo.service.services.interfaces.ICandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/candidates")
public class CandidateController {

    private final ICandidateService candidateService;

    @GetMapping
    public ResponseEntity<List<CandidateDto>> getCandidates() {
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }

    @GetMapping("/{id}")
    public CandidateDto getCandidateById(@PathVariable Long id) {
        return candidateService.getCandidateById(id);
    }

    @PostMapping
    public CandidateDto addCandidate(@RequestBody CandidateDto candidateDto) {
        return candidateService.saveCandidate(candidateDto);
    }

    @PutMapping("/{id}")
    public CandidateDto updateCandidate(@PathVariable Long id, @RequestBody CandidateDto candidateDto) {
        candidateDto.setId(id);
        return candidateService.saveCandidate(candidateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
    }
}
