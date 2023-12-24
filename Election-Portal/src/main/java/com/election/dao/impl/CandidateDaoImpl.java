package com.election.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.election.dao.CandidateDao;
import com.election.entities.Candidate;
import com.election.repository.CandidateRepository;

@Repository("candidateDao")
public class CandidateDaoImpl implements CandidateDao {
	
	@Autowired
	CandidateRepository candidaeRepository;

	@Override
	public Candidate createCandidate(Candidate candidate) {
		return candidaeRepository.save(candidate);

	}

	@Override
	public Candidate findByCandidateName(String candidateName) {
		
		return candidaeRepository.findByCandidateName(candidateName);
	}

	@Override
	public Candidate updateCandidate(Candidate candidate) {
		
		return candidaeRepository.save(candidate);
	}

	@Override
	public List<Candidate> findAll() {
		// TODO Auto-generated method stub
		return candidaeRepository.findAll();
	}

}
