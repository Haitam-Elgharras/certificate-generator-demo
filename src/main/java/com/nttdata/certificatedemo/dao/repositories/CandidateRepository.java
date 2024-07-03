package com.nttdata.certificatedemo.dao.repositories;

import com.nttdata.certificatedemo.dao.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
