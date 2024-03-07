package com.alumniNetworkProtocol.AlumniNetworkProtocol.services.impl;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.User;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Repositories.UserRepo;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.apis.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private  UserRepo userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService(){
            @Override
            public User loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("userNotFound"));
            }
        };
    }
}

