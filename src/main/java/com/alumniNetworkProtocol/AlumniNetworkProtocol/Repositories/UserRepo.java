package com.alumniNetworkProtocol.AlumniNetworkProtocol.Repositories;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);

    User getByEmail(String email);
}
