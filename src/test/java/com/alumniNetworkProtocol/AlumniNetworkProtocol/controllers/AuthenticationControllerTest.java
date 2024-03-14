package com.alumniNetworkProtocol.AlumniNetworkProtocol.controllers;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.DTOs.SignInRequest;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.DTOs.SignUpRequest;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.DTOs.JwtAuthenticationResponse;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Candidate;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.User;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Repositories.CandidateRepository;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Repositories.UserRepo;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.apis.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthenticationControllerTest {

    @Mock
    private AuthenticationService authenticationService;

    @Mock
    private UserRepo userRepo;

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private AuthenticationController authenticationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSignUpExistingCandidateAndUser() {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setEmail("existing@test.com");

        Candidate existingCandidate = new Candidate();
        existingCandidate.setEmail("existing@test.com");
        when(candidateRepository.findByEmail("existing@test.com")).thenReturn(Optional.of(existingCandidate));

        User existingUser = new User();
        existingUser.setEmail("existing@test.com");
        when(userRepo.findByEmail("existing@test.com")).thenReturn(Optional.of(existingUser));

        String response = authenticationController.signUp(signUpRequest);
        assertEquals("user with this email is already registered", response);
    }

    @Test
    public void testSignUpExistingCandidateNewUser() {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setEmail("existing@test.com");

        Candidate existingCandidate = new Candidate();
        existingCandidate.setEmail("existing@test.com");
        when(candidateRepository.findByEmail("existing@test.com")).thenReturn(Optional.of(existingCandidate));

        when(userRepo.findByEmail("existing@test.com")).thenReturn(Optional.empty());

        when(authenticationService.signUp(signUpRequest)).thenReturn("SignUp Successful");

        String response = authenticationController.signUp(signUpRequest);
        assertEquals("SignUp Successful", response);
    }


    @Test
    public void testSignIn() {
        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setEmail("username");
        signInRequest.setPassword("password");

        JwtAuthenticationResponse authenticationResponse = new JwtAuthenticationResponse("token", "Bearer");

        when(authenticationService.signin(signInRequest)).thenReturn(authenticationResponse);

        ResponseEntity<JwtAuthenticationResponse> responseEntity = authenticationController.signin(signInRequest);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(authenticationResponse, responseEntity.getBody());
    }
}

