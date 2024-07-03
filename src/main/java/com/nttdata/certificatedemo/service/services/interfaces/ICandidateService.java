package com.nttdata.certificatedemo.service.services.interfaces;

import com.nttdata.certificatedemo.service.dtos.CandidateDto;

import java.util.List;

public interface ICandidateService {
    List<CandidateDto> getAllCandidates();
    CandidateDto getCandidateById(Long id);
    CandidateDto saveCandidate(CandidateDto candidate);
    CandidateDto updateCandidate(CandidateDto candidate);
    void deleteCandidate(Long id);
}
