package com.alumniNetworkProtocol.AlumniNetworkProtocol.services.apis;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Alumni;

import java.util.List;
import java.util.Optional;

public interface AlumniService {

    List<Alumni> getAllAlumni();
    Alumni getAlumni(Long id);
    Optional<Alumni> getAlumniByYear(int year);
    Alumni createAlumni(Alumni alumni);
    Alumni updateAlumni(Long id, Alumni updatedAlumni);
    void deleteAlumni(Long id);
}
