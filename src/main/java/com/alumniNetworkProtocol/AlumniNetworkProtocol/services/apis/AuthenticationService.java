package com.alumniNetworkProtocol.AlumniNetworkProtocol.services.apis;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.DTOs.*;
public interface AuthenticationService {

    String signUp(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SignInRequest signInRequest);

}
