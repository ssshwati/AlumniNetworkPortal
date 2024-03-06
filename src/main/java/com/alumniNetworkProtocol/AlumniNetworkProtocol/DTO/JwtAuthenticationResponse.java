package com.alumniNetworkProtocol.AlumniNetworkProtocol.DTO;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String token;
    private String email;

}
