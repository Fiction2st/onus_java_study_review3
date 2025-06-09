package com.onus.crud_project_review2.services.impl;

import com.onus.crud_project_review2.services.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.concurrent.Executor;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;
    private final Executor executor;

    public EmailServiceImpl(
            JavaMailSender mailSender,
            SpringTemplateEngine templateEngine,
            @Qualifier("emailExecutor") Executor executor
    ){
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
        this.executor = executor;
    }

    @Override
    public void sendEmail(String to, String name) {
        executor.execute(() -> {
            try {
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

                Context context = new Context();
                context.setVariable("name", name);
                String content = templateEngine.process("welcome-email", context);

                helper.setTo(to);
                helper.setSubject("Welcome to Onus");
                helper.setText(content, true);

                mailSender.send(mimeMessage);
            } catch (Exception e) {
                System.err.println("이메일 전송에러" + e.getMessage());
                e.printStackTrace();
            }
        });
    }
}
