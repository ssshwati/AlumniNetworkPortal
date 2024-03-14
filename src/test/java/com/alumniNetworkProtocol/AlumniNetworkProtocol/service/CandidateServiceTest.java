package com.alumniNetworkProtocol.AlumniNetworkProtocol.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.impl.CandidateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Candidate;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Repositories.CandidateRepository;

public class CandidateServiceTest {
    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateServiceImpl candidateService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCandidate() {
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate());
        candidates.add(new Candidate());
        when(candidateRepository.findAll()).thenReturn(candidates);
        List<Candidate> result = candidateService.getAllCandidate();

        assertEquals(2, result.size());

    }

    @Test
    public void testGetCandidate() {
        Candidate candidate = new Candidate();
        long id = 1;
        when(candidateRepository.findById(id)).thenReturn(Optional.of(candidate));
        Optional<Candidate> result = candidateService.getCandidate(id);
        assertEquals(candidate, result.orElse(null));
    }

    @Test
    public void testCreateCandidate() {
        Candidate candidate = new Candidate();
        when(candidateRepository.save(candidate)).thenReturn(candidate);
        Candidate result = candidateService.createCandidate(candidate);
        assertEquals(candidate, result);
    }

    @Test
    public void testDeleteCandidate() {
        candidateService.deleteCandidate(1L);
        verify(candidateRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateCandidate() {
        Candidate existingCandidate = new Candidate();
        Candidate updatedCandidate = new Candidate();
        when(candidateRepository.existsById(1L)).thenReturn(true);
        when(candidateRepository.save(updatedCandidate)).thenReturn(updatedCandidate);
        Candidate result = candidateService.updateCandidate(1L, updatedCandidate);
        assertEquals(updatedCandidate, result);
    }

    @Test
    public void testUpdateCandidateNonExisting() {
        Candidate updatedCandidate = new Candidate();
        when(candidateRepository.existsById(1L)).thenReturn(false);
        Candidate result = candidateService.updateCandidate(1L, updatedCandidate);
        assertEquals(null, result);
    }
}
