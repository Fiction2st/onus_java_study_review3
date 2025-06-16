package com.onus.crud_project_review2.services;

import com.onus.crud_project_review2.dtos.EmailDTO;
import com.onus.crud_project_review2.dtos.EmailVerifyRequestDTO;

public interface AuthService {
    String sendVerificationCode(EmailDTO emailDTO);
    boolean verifyEmailCode(EmailVerifyRequestDTO emailVerifyRequestDTO);
}