package com.enoca.project.service;


import com.enoca.project.model.dto.UserDto;
import com.enoca.project.model.entity.User;
import com.enoca.project.model.mapper.UserMapper;
import com.enoca.project.model.request.UserCreateRequest;
import com.enoca.project.model.request.UserUpdateRequest;
import com.enoca.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDto> list = userList.stream().map(userMapper::toUserDto).toList();
        return list;
    }

    public ResponseEntity<UserCreateRequest> createUser(UserCreateRequest userCreateRequest) {
        User user = userMapper.toUserCreate(userCreateRequest);
        userRepository.save(user);
        return ResponseEntity.ok().body(userCreateRequest);
    }

    public UserDto getOneUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return userMapper.toUserDto(user);
    }

    public UserUpdateRequest updateOneUser(Long userId, UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setPhoneNumber(user.getPhoneNumber());
        user.setGender(user.getGender());
        user.setPhoneNumber(user.getPhoneNumber());
        user.setCompany(user.getCompany());
        userMapper.toUserUpdate(userUpdateRequest, user);
        userRepository.save(user);
        return userUpdateRequest;
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

}
