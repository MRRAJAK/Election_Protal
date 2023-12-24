package com.election.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.election.constants.CandidateConstants;
import com.election.dao.CandidateDao;
import com.election.entities.Candidate;
import com.election.models.CandidateResponse;
import com.election.models.CandidatesResponse;
import com.election.models.Response;

@Service
public class CandidateService {
	
	@Autowired
	private CandidateDao candidateDao;

	public Response createCandidate(Candidate candidate) {
		// TODO Auto-generated method stub
		CandidateResponse response = new CandidateResponse();
		Candidate us = candidateDao.createCandidate(candidate);
		response.setCondidateName(us.getCandidateName());
		response.setErrorCode(CandidateConstants.CANDIDATE_SUCCESS_CODE);
		response.setErrorMessage(CandidateConstants.CANDIDATE_CREATED_SUCCESS);
	
		return response;
	}

	public Candidate findByCondidateName(String candidateName) {
		Candidate us = candidateDao.findByCandidateName(candidateName);
		return us;
	}

	public Response updateCandidate(Candidate candidate) {
		Response response = new Response();
		candidateDao.updateCandidate(candidate);
		response.setErrorCode(CandidateConstants.CANDIDATE_VOTE_SUCCESS_CODE);
		response.setErrorMessage(CandidateConstants.CANDIDATE_VOTE_SUCCESS_MSG);
		return response;
	}

	public List<Candidate> findAll() {
		
		List<Candidate> cd= candidateDao.findAll();
		return cd;
	}

}
