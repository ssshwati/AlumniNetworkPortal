package com.alumniNetworkProtocol.AlumniNetworkProtocol.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Candidate;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.User;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	Optional<Candidate> findByEmail(String email);
}
