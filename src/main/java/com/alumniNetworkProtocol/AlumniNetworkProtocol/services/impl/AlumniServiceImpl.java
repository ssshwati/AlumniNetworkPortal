package com.alumniNetworkProtocol.AlumniNetworkProtocol.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Alumni;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Repositories.AlumniRepository;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.apis.AlumniService;

@Service
public class AlumniServiceImpl implements AlumniService {
	 @Autowired
	    private AlumniRepository alumniRepository;

	    public List<Alumni> getAllAlumni() {
	        return alumniRepository.findAll();
	    }

		public Alumni getAlumni(@PathVariable Long id) {
		    return alumniRepository.findById(id).orElse(null);
		}
		
		public Alumni createAlumni(@RequestBody Alumni alumni) {
		    return alumniRepository.save(alumni);
		}
		
		public Alumni updateAlumni(@PathVariable Long id, @RequestBody Alumni updatedAlumni) {
		    if (alumniRepository.existsById(id)) {
		        updatedAlumni.setId(id);
		        return alumniRepository.save(updatedAlumni);
		    } else {
		        return null; // Handle not found
		    }
		}
		
	    public void deleteAlumni(@PathVariable Long id) {
	        alumniRepository.deleteById(id);
	    }

}
