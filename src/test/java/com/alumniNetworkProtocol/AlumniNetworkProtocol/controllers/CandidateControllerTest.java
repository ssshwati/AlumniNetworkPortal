package com.alumniNetworkProtocol.AlumniNetworkProtocol.controllers;


import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Alumni;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Candidate;
import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.apis.CandidateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class CandidateControllerTest {


    private MockMvc mockMvc;

    @Mock
    private CandidateService candidateService;

    @InjectMocks
    private CandidateController candidateController;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(candidateController).build();
    }



    @Test
    public void testCreateCandidate_404() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/auth/user/alumni/save");
        mockMvc.perform(request.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }
    @Test
    public void testCreateCandidate_405() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/auth/admin/candidate/save");
        mockMvc.perform(request.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isMethodNotAllowed());
    }


    @Test
    public void testGetAllCandidate_200() throws Exception {
        List<Candidate> candidateList = new ArrayList<>(); // create a list of Alumni
        when(candidateService.getAllCandidate()).thenReturn(candidateList);
        mockMvc.perform(MockMvcRequestBuilders.get("/auth/admin/candidate/getAllCandidate"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAllCandidate_404() throws Exception {
        List<Candidate> candidateList = new ArrayList<>(); // create a list of Alumni
        when(candidateService.getAllCandidate()).thenReturn(candidateList);
        mockMvc.perform(MockMvcRequestBuilders.get("/auth/user/alumni/getAll"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testGetCandidate_200() throws Exception {
        Candidate candidate = new Candidate();
        when(candidateService.getCandidate(anyLong())).thenReturn(Optional.of(candidate));

        mockMvc.perform(MockMvcRequestBuilders.get("/auth/admin/candidate/getCandidate/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateCandidate_404() throws Exception {
        Candidate candidate = new Candidate();
        when(candidateService.updateCandidate(anyLong(), any(Candidate.class))).thenReturn(candidate);

        mockMvc.perform(MockMvcRequestBuilders.put("/auth/user/alumni/updateAlumni/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testDeleteCandidate_200() throws Exception {
        doNothing().when(candidateService).deleteCandidate(anyLong());

        mockMvc.perform(MockMvcRequestBuilders.delete("/auth/admin/candidate/deleteCandidate/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}