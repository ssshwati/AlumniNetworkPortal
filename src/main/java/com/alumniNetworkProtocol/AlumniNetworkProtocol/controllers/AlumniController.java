package com.alumniNetworkProtocol.AlumniNetworkProtocol.controllers;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Alumni;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.apis.AlumniService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth/user/alumni")
public class AlumniController {

    @Autowired
    private AlumniService alumniService;
    
    @PostMapping("/save")//POST 
	public Alumni createAlumni(@RequestBody Alumni alumni) {
	    return alumniService.createAlumni(alumni);
	}

    @GetMapping("/getAll")//SELECT
    public List<Alumni> getAllAlumni() {
        return alumniService.getAllAlumni();
    }

    @GetMapping("getAlumni/{id}")//GET
	public Alumni getAlumni(@PathVariable Long id) {
	    return alumniService.getAlumni(id);
	}

	@GetMapping("getAlumniByYear/{year}")//GET
	public Optional<Alumni> getAlumni(@PathVariable int year) {
		return alumniService.getAlumniByYear(year);
	}


	@PutMapping("updateAlumni/{id}")//PUT
	public Alumni updateAlumni(@PathVariable Long id, @RequestBody Alumni updatedAlumni) {
	    return alumniService.updateAlumni(id, updatedAlumni);
	}
	
	@DeleteMapping("deleteAlumni/{id}")//DELETE
    public void deleteAlumni(@PathVariable Long id) {
		alumniService.deleteAlumni(id);
    }
}
