package com.alumniNetworkProtocol.AlumniNetworkProtocol.services.apis;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Alumni;

import java.util.List;

public interface AlumniService {

    List<Alumni> getAllAlumni();
    Alumni getAlumni(Long id);
    Alumni createAlumni(Alumni alumni);
    Alumni updateAlumni(Long id, Alumni updatedAlumni);
    void deleteAlumni(Long id);
}
