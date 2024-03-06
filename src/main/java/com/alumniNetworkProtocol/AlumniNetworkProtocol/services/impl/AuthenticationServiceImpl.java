package com.alumniNetworkProtocol.AlumniNetworkProtocol.services.impl;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.DTO.JwtAuthenticationResponse;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.DTO.SignInRequest;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.DTO.SignUpRequest;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.User;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Repositories.UserRepo;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.api.AuthenticationService;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.api.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private  UserRepo userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private  JwtService jwtService;

    @Override
    public String signUp(SignUpRequest signUpRequest) {
        try {
            User user = new User();
            user.setName(signUpRequest.getName());
            user.setEmail(signUpRequest.getEmail());
            user.setPassword(signUpRequest.getPassword());
            user.setPhone(signUpRequest.getPhone());
            user.setCohort(signUpRequest.getCohort());
            user.setRole(signUpRequest.getRole());

            userRepository.save(user);
            String message = "registered successfully";
            System.out.println("User saved"); // Use log.info instead of System.out.println
            return message;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "invalid data";
        }
    }

    @Override
    public JwtAuthenticationResponse signin(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
        var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(()->new IllegalArgumentException("invalid email or password"));

        return null;
    }
}
