package com.onus.crud_project_review2.services.impl;

import com.onus.crud_project_review2.dtos.user.UserDTO;
import com.onus.crud_project_review2.dtos.user.UserResponseDTO;
import com.onus.crud_project_review2.entities.Users;

import com.onus.crud_project_review2.mapper.UserMapper;
import com.onus.crud_project_review2.repositories.UserRepository;

import com.onus.crud_project_review2.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(UserDTO userDTO) {
        if(userRepository.existsByEmail(userDTO.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        Users user = UserMapper.mapToUser(userDTO);
        Users savedUser = userRepository.save(user);

        return UserMapper.mapToUserResponseDTO(savedUser);
    }
}
