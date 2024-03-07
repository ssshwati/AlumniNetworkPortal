package com.alumniNetworkProtocol.AlumniNetworkProtocol.services.api;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.DTO.*;
public interface AuthenticationService {

    String signUp(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SignInRequest signInRequest);

}
