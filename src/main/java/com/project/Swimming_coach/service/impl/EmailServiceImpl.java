package com.project.Swimming_coach.service.impl;

import com.project.Swimming_coach.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendForgetPasswordToken(String email,String token) {
        System.out.println("URl is sent to "+email+"and Url is: "+token);
    }
}
