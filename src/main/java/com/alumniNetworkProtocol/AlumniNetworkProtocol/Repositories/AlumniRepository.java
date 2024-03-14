package com.alumniNetworkProtocol.AlumniNetworkProtocol.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Alumni;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.User;


public interface AlumniRepository extends JpaRepository<Alumni, Long> {
}
