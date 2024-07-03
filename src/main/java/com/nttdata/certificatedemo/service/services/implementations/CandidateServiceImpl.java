package com.nttdata.certificatedemo.service.services.implementations;

import com.nttdata.certificatedemo.dao.entities.Candidate;
import com.nttdata.certificatedemo.dao.repositories.CandidateRepository;
import com.nttdata.certificatedemo.service.dtos.CandidateDto;
import com.nttdata.certificatedemo.service.mappers.ICandidateMapper;
import com.nttdata.certificatedemo.service.services.interfaces.ICandidateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CandidateServiceImpl implements ICandidateService {

    private final CandidateRepository candidateRepository;
    private final ICandidateMapper candidateMapper;

    @Override
    public List<CandidateDto> getAllCandidates() {
        List<Candidate> candidates = candidateRepository.findAll();
        return candidates.stream().map(candidateMapper::candidateToCandidateDto).collect(Collectors.toList());
    }

    @Override
    public CandidateDto getCandidateById(Long id) {
        Candidate candidate = candidateRepository.findById(id).orElse(null);

        if (candidate == null)
            return null;

        return candidateMapper.candidateToCandidateDto(candidate);
    }

    @Override
    public CandidateDto saveCandidate(CandidateDto candidate) {
        Candidate candidateEntity = candidateMapper.candidateDtoToCandidate(candidate);
        Candidate savedCandidate = candidateRepository.save(candidateEntity);

        return candidateMapper.candidateToCandidateDto(savedCandidate);
    }

    @Override
    public CandidateDto updateCandidate(CandidateDto candidate) {
        Candidate candidateEntity = candidateMapper.candidateDtoToCandidate(candidate);
        Candidate updatedCandidate = candidateRepository.save(candidateEntity);

        return candidateMapper.candidateToCandidateDto(updatedCandidate);
    }

    @Override
    public void deleteCandidate(Long id) {
        // Check if the candidate exists
        if (candidateRepository.existsById(id)) {
            candidateRepository.deleteById(id);
        }
    }
}
