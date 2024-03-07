package com.alumniNetworkProtocol.AlumniNetworkProtocol.controllers;


import com.alumniNetworkProtocol.AlumniNetworkProtocol.DTOs.JwtAuthenticationResponse;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.DTOs.SignInRequest;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.DTOs.SignUpRequest;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.User;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Repositories.UserRepo;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.apis.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpRequest signUpRequest){
        Optional<User> existingUser = userRepo.findByEmail(signUpRequest.getEmail());
        if(existingUser.isPresent()){
            return "user with this email is already registered";
        }else{
            return authenticationService.signUp(signUpRequest);
        }
    }

//    @PostMapping("/signin")
//    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest){
//        return ResponseEntity.ok(authenticationService.signin(signInRequest));
//    }
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest){
        JwtAuthenticationResponse response = authenticationService.signin(signInRequest);
        return ResponseEntity.ok(response);
    }

}
