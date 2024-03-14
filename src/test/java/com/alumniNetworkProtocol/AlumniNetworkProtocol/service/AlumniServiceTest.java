package com.alumniNetworkProtocol.AlumniNetworkProtocol.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.impl.AlumniServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Alumni;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Repositories.AlumniRepository;

public class AlumniServiceTest {

    @Mock
    private AlumniRepository alumniRepository;

    @InjectMocks
    private AlumniServiceImpl alumniService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllAlumni() {
        List<Alumni> alumniList = new ArrayList<>();
        alumniList.add(new Alumni());
        alumniList.add(new Alumni());

        when(alumniRepository.findAll()).thenReturn(alumniList);

        List<Alumni> result = alumniService.getAllAlumni();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetAlumni() {
        Alumni alumni = new Alumni();
        when(alumniRepository.findById(1L)).thenReturn(Optional.of(alumni));
        Alumni result = alumniService.getAlumni(1L);
        assertEquals(alumni, result);
    }

    @Test
    public void testCreateAlumni() {
        Alumni alumni = new Alumni();
        when(alumniRepository.save(alumni)).thenReturn(alumni);
        Alumni result = alumniService.createAlumni(alumni);
        assertEquals(alumni, result);
    }

    @Test
    public void testUpdateAlumni() {
        Alumni existingAlumni = new Alumni();
        Alumni updatedAlumni = new Alumni();
        when(alumniRepository.existsById(1L)).thenReturn(true);
        when(alumniRepository.save(updatedAlumni)).thenReturn(updatedAlumni);
        Alumni result = alumniService.updateAlumni(1L, updatedAlumni);
        assertEquals(updatedAlumni, result);
    }

    @Test
    public void testUpdateAlumniNonExisting() {
        Alumni updatedAlumni = new Alumni();
        when(alumniRepository.existsById(1L)).thenReturn(false);
        Alumni result = alumniService.updateAlumni(1L, updatedAlumni);
        assertEquals(null, result);
    }

    @Test
    public void testDeleteAlumni() {
        alumniService.deleteAlumni(1L);
        verify(alumniRepository, times(1)).deleteById(1L);
    }
}
