package com.alumniNetworkProtocol.AlumniNetworkProtocol.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Candidate;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Repositories.CandidateRepository;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.apis.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public List<Candidate> getAllCandidate() {
		return candidateRepository.findAll();
	}
	
	@Override
	public Optional<Candidate> getCandidate(Long id) {
		return candidateRepository.findById(id);
	}

	@Override
	public Candidate createCandidate(Candidate candidate) {
		return candidateRepository.save(candidate);
	}

	@Override
	public void deleteCandidate(Long id) {
		candidateRepository.deleteById(id);
	}


	@Override
	public Candidate updateCandidate(Long id, Candidate updatedCandidate) {
		if (candidateRepository.existsById(id)) {
			updatedCandidate.setId(id);
			return candidateRepository.save(updatedCandidate);
		} else
			return null;
	}

}
