package com.nttdata.certificatedemo.service.mappers;

import com.nttdata.certificatedemo.dao.entities.Candidate;
import com.nttdata.certificatedemo.service.dtos.CandidateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICandidateMapper {
    Candidate candidateDtoToCandidate(CandidateDto candidateDto);
    CandidateDto candidateToCandidateDto(Candidate candidate);
}
