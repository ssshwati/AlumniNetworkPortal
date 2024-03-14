package com.alumniNetworkProtocol.AlumniNetworkProtocol.Repositories;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Alumni;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.User;

import java.util.Optional;


public interface AlumniRepository extends JpaRepository<Alumni, Long> {

    Optional<Alumni> findByYear(int year );

}
