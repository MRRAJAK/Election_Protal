package com.election.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.election.constants.CandidateConstants;
import com.election.entities.Candidate;
import com.election.models.Response;
import com.election.services.CandidateService;

@RestController
public class MachineController {

	@Autowired
	private CandidateService candidateService;

	// Create a canditate
	@PostMapping("/enterCandidate")
	public ResponseEntity<Response> createCandidate(@RequestParam String candidateName) {
		Response response = new Response();
		Candidate candidate = new Candidate();
		Candidate candidates = candidateService.findByCondidateName(candidateName);
		if (candidateName == null) {
			response.setErrorCode(CandidateConstants.ERROR_CODE_01);
			response.setErrorMessage(CandidateConstants.ERROR_LU01_MESSAGE);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

		} else if ((candidates != null) && candidates.getCandidateName().equals(candidateName)) {
			response.setErrorCode(CandidateConstants.ERROR_CODE_03);
			response.setErrorMessage(CandidateConstants.ERROR_LU03_MESSAGE);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		} else {

			int count = 0;
			candidate.setCount(count);
			candidate.setCandidateName(candidateName);
			response = candidateService.createCandidate(candidate);

		}

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// voting a conditate
	@PutMapping("/castvote")
	public ResponseEntity<Response> voting(@RequestParam String candidateName) {
		Response response = new Response();
		Candidate candidate = new Candidate();
		Candidate candidates = candidateService.findByCondidateName(candidateName);
		if (candidates == null) {
			response.setErrorCode(CandidateConstants.ERROR_CODE_02);
			response.setErrorMessage(CandidateConstants.ERROR_LU02_MESSAGE);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

		} else {

			int count = candidates.getCount() + 1;
			candidate.setCount(count);
			candidate.setCandidateId(candidates.getCandidateId());
			candidate.setCandidateName(candidates.getCandidateName());
			candidate.setCandidateName(candidateName);
			response = candidateService.updateCandidate(candidate);

		}

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// Get All Candidates
	@GetMapping("/listvote")
	public List<Candidate> getAll() {
		List<Candidate> candidates = candidateService.findAll();
		return candidates;
	}

	// Get winner Condidate
	@GetMapping("/getwinner")
	public Candidate getWinnerCandidate() {
		Candidate candidate = new Candidate();
		List<Candidate> cod = candidateService.findAll();
		Integer heighest = cod.stream().map(e -> e.getCount()).sorted(Collections.reverseOrder()).findFirst().get();
		for (Candidate c : cod) {
			if (c.getCount() == heighest) {
				candidate.setCandidateId(c.getCandidateId());
				candidate.setCandidateName(c.getCandidateName());
				candidate.setCount(c.getCount());
			}
		}

		return candidate;
	}

	// Get Candidate by the Name
	@GetMapping("/countvote")
	public Candidate getIndividualCandidate(@RequestParam String candidateName) {
		Candidate candidates = candidateService.findByCondidateName(candidateName);

		return candidates;
	}

}
