package com.enoca.project.controller;

import com.enoca.project.model.entity.Company;
import com.enoca.project.model.entity.User;
import com.enoca.project.model.request.UserCreateRequest;
import com.enoca.project.repository.UserRepository;
import com.enoca.project.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static com.enoca.project.model.type.Gender.FEMALE;
import static com.enoca.project.model.type.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @Test
    void getAllUsers() {

        UserRepository userRepository = mock(UserRepository.class);

        List<User> usersToSave = new ArrayList<>();
        usersToSave.add(new User(1L, "muhammed", "123", "muhammed_demirell@hotmail.com", "05453513511", MALE, null));
        usersToSave.add(new User(2L, "nur", "321", "nur_demirell@hotmail.com", "05453513512", FEMALE, null));

        when(userRepository.saveAll(usersToSave)).thenReturn(usersToSave);

        when(userRepository.findAll()).thenReturn(usersToSave);

        List<User> savedUsers = userRepository.saveAll(usersToSave);
        List<User> retrievedUsers = userRepository.findAll();

        assertEquals(usersToSave, savedUsers);
        assertEquals(usersToSave, retrievedUsers);
    }

    @Test
    void createUser() {
        UserCreateRequest mockCreateUserRequest = new UserCreateRequest();
        mockCreateUserRequest.setCompany(null);
        mockCreateUserRequest.setId(1L);
        mockCreateUserRequest.setGender(MALE);
        mockCreateUserRequest.setEmail("muhammed_demirell@hotmail.com");
        mockCreateUserRequest.setFirstName("muhammed");
        mockCreateUserRequest.setLastName("demirel");
        assertEquals("muhammed", mockCreateUserRequest.getFirstName());
        assertEquals("demirel", mockCreateUserRequest.getLastName());
        assertEquals(null,mockCreateUserRequest.getCompany());
        assertEquals(MALE, mockCreateUserRequest.getGender());
        assertEquals("muhammed_demirell@hotmail.com", mockCreateUserRequest.getEmail());
        assertEquals(1L, mockCreateUserRequest.getId());
    }
}