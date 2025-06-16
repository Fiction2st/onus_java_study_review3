package com.onus.crud_project_review2.services;

public interface EmailService {
    void sendEmail(String to, String name);
    void sendVerificationCodeEmail(String to, String code);
}
