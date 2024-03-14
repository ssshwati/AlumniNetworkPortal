package com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities;


import com.alumniNetworkProtocol.AlumniNetworkProtocol.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
   
    public Candidate(long l, String name) {
    	this.id=id;
    	this.name=name;
	}
    
    public Candidate() {
    	
    }

	public Long getId() {
        return id;
    }

    public void setId(long id2) {
        this.id = id2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
