package com.election.dao;

import java.util.List;

import com.election.entities.Candidate;

public interface CandidateDao {

	Candidate createCandidate(Candidate candidate);

	Candidate findByCandidateName(String candidateName);

	Candidate updateCandidate(Candidate candidate);

	List<Candidate> findAll();

}
