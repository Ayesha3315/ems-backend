package com.ayesha.employee_management_system.service;

import com.ayesha.employee_management_system.model.Email;
import com.ayesha.employee_management_system.repository.EmailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private EmailRepo emailRepository;

    private void sendEmail(String to,String subject,String body){
        Email email=new Email();
        email.setRecipient(to);
        email.setSubject(subject);
        email.setMessage(body);
        email.setSentAt(LocalDateTime.now());

        try{
            SimpleMailMessage message=new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);

            mailSender.send(message);
            email.setStatus("SUCCESS");
        } catch (Exception e) {
            email.setStatus("FAILURE");
        }
        emailRepository.save(email);
    }

    public void sendResetLink(String toEmail,String resetLink){
        String subject="Password Reset Link Request";
        String body="Hello \n\n Click the link below to reset your password:\n"+resetLink+"\n If its not you please ignore this email.";
        sendEmail(toEmail,subject,body);
    }
}
