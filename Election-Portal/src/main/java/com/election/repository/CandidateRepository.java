package com.election.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.election.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

	Candidate findByCandidateName(String candidateName);

}
