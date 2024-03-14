package com.alumniNetworkProtocol.AlumniNetworkProtocol.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Candidate;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.User;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.apis.CandidateService;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.apis.UserService;


@RestController
@RequestMapping("/auth/admin/candidate")
public class CandidateController {
	 @Autowired
	    private CandidateService candidateService;
	 

	    @PostMapping("/save")
	    public Candidate createUser(@RequestBody Candidate candidate) {
	        return candidateService.createCandidate(candidate);
	    }

	    @GetMapping("/getAllCandidate")
	    public List<Candidate> getAllCandidate() {
	        return candidateService.getAllCandidate();
	    }

	    @GetMapping("/getCandidate/{id}")
	    public Optional<Candidate> getCandidate(@PathVariable Long id) {
	        return candidateService.getCandidate(id);
	    }

	    @PutMapping("/updateCandidate/{id}")
	    public Candidate updateCandidate(@PathVariable Long id, @RequestBody Candidate updatedcandidate) {
	        return candidateService.updateCandidate(id,updatedcandidate);
	    }

	    @DeleteMapping("/deleteCandidate/{id}")
	    public void deleteCandidate(@PathVariable Long id) {
	    	candidateService.deleteCandidate(id);
	    }

}
