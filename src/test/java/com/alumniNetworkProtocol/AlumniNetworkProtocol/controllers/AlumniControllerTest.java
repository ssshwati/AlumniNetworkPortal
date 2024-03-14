package com.alumniNetworkProtocol.AlumniNetworkProtocol.controllers;


import com.alumniNetworkProtocol.AlumniNetworkProtocol.Entities.Alumni;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.alumniNetworkProtocol.AlumniNetworkProtocol.services.apis.AlumniService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class AlumniControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AlumniService alumniService;

    @InjectMocks
    private AlumniController alumniController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(alumniController).build();
    }

    @Test
    public void testCreateAlumni() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/auth/user/alumni/save");
        mockMvc.perform(request.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void testCreateAlumni_404() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("//auth/user/alumni/save");
        mockMvc.perform(request.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

    @Test
    public void testGetAllAlumni() throws Exception {
        List<Alumni> alumniList = new ArrayList<>(); // create a list of Alumni
        when(alumniService.getAllAlumni()).thenReturn(alumniList);
        mockMvc.perform(MockMvcRequestBuilders.get("/auth/user/alumni/getAll"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAlumni() throws Exception {
        Alumni alumni = new Alumni(); // create an instance of Alumni
        when(alumniService.getAlumni(anyLong())).thenReturn(alumni);

        mockMvc.perform(MockMvcRequestBuilders.get("/auth/user/alumni/getAlumni/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateAlumni() throws Exception {
        Alumni alumni = new Alumni(); // create an instance of Alumni
        when(alumniService.updateAlumni(anyLong(), any(Alumni.class))).thenReturn(alumni);

        mockMvc.perform(MockMvcRequestBuilders.put("/auth/user/alumni/updateAlumni/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteAlumni() throws Exception {
        doNothing().when(alumniService).deleteAlumni(anyLong());
        mockMvc.perform(MockMvcRequestBuilders.delete("/auth/user/alumni/deleteAlumni/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

