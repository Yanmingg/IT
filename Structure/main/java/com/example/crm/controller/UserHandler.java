package com.example.crm.controller;

import com.example.crm.entity.Contact;
import com.example.crm.entity.User;
import com.example.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.crm.entity.Email;
import com.example.crm.methods.EmailSender;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;
    private EmailSender emailSender = new EmailSender();

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody Email email) throws IOException, MessagingException {
        try {
            emailSender.sendOneEmail(email.address,email.subject,email.body);
        }catch (MessagingException e){
            return "fail";
        }
        return "successful";
    }

    @GetMapping("/findid/{id}")
    public User findId(@PathVariable("id") Integer id){
        return userRepository.findById(id).get();
    }

    @DeleteMapping("/deleteid/{id}")
    public void deleteId(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }


}
