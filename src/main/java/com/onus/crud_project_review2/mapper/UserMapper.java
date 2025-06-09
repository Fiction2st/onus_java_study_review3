package com.onus.crud_project_review2.mapper;

import com.onus.crud_project_review2.dtos.user.UserDTO;
import com.onus.crud_project_review2.dtos.user.UserResponseDTO;
import com.onus.crud_project_review2.entities.Users;

public class UserMapper {
    public static Users mapToUser(UserDTO userDTO){
        Users users = new Users();
        users.setEmail(userDTO.getEmail());
        users.setPassword(userDTO.getPassword());
        users.setUserName(userDTO.getUserName());
        return users;
    }

    public static UserResponseDTO mapToUserResponseDTO(Users users){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setEmail(users.getEmail());
        userResponseDTO.setPassword(users.getPassword());
        userResponseDTO.setUserName(users.getUserName());

        return userResponseDTO;
    }
}
