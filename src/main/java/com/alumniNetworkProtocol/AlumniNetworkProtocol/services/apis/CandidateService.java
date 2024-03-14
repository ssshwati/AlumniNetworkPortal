package com.alumniNetworkProtocol.AlumniNetworkProtocol.services.apis;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Alumni;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Candidate;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.User;

public interface CandidateService {

	List<Candidate> getAllCandidate();

	Optional<Candidate> getCandidate(Long id);

	Candidate createCandidate(Candidate candidate);

	Candidate updateCandidate(Long id, Candidate updatedCandidate);

	void deleteCandidate(Long id);
}
