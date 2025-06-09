package com.onus.crud_project_review2.services;

import com.onus.crud_project_review2.dtos.user.UserDTO;
import com.onus.crud_project_review2.dtos.user.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(UserDTO userDTO);

}
