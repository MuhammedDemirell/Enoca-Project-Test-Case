package com.enoca.project.controller;

import com.enoca.project.model.entity.Company;
import com.enoca.project.model.request.CompanyCreateRequest;
import com.enoca.project.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CompanyControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Mock
    private CompanyRepository companyRepository;

    @Test
    void getAllCompany() {
        CompanyRepository companyRepository = mock(CompanyRepository.class);

        List<Company> companyToSave = new ArrayList<>();
        companyToSave.add(new Company(1L, "muhammed", "123", "05458112511", "muhammed_muhammed@hotmail.com", 11, null));
        companyToSave.add(new Company(2L, "melih", "321", "05458112512", "melih_melih@hotmail.com", 12, null));

        when(companyRepository.saveAll(companyToSave)).thenReturn(companyToSave);

        when(companyRepository.findAll()).thenReturn(companyToSave);

        List<Company> savedUsers = companyRepository.saveAll(companyToSave);
        List<Company> retrievedUsers = companyRepository.findAll();

        assertEquals(companyToSave, savedUsers);
        assertEquals(companyToSave, retrievedUsers);
    }

    @Test
    void createCompany() {
        CompanyCreateRequest mockCreateCompanyRequest = new CompanyCreateRequest();
        mockCreateCompanyRequest.setId(1L);
        mockCreateCompanyRequest.setName("Enoca");
        mockCreateCompanyRequest.setAddress("Esenler");
        mockCreateCompanyRequest.setPhoneNumber("05458112511");
        mockCreateCompanyRequest.setEmail("Enoca@hotmail.com");
        mockCreateCompanyRequest.setEmployeeCount(15);
        mockCreateCompanyRequest.setUser(null);

        assertEquals("Enoca", mockCreateCompanyRequest.getName());
        assertEquals("Esenler", mockCreateCompanyRequest.getAddress());
        assertEquals(null,mockCreateCompanyRequest.getUser());
        assertEquals("Enoca@hotmail.com", mockCreateCompanyRequest.getEmail());
        assertEquals(1L, mockCreateCompanyRequest.getId());
        assertEquals("05458112511", mockCreateCompanyRequest.getPhoneNumber());
        assertEquals(15, mockCreateCompanyRequest.getEmployeeCount());
    }
}