package com.example.crm.controller;

import com.example.crm.entity.Account;
import com.example.crm.entity.Email;
import com.example.crm.entity.Task;
import com.example.crm.entity.User;
import com.example.crm.methods.EmailSender;
import com.example.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


import com.example.crm.methods.EmailSender;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;
    private EmailSender emailSender;
    @GetMapping("/findAll")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody User user){
        User result = userRepository.save(user);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
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

    @PostMapping("/login")
    public String login(@RequestBody Account account){
        List<User> users = userRepository.findAll();
        for (User user : users){
            if (user.getEmail().equals(account.getUseraccount())){
                if(user.getPassword().equals(account.getPassword())) {
                    return "find";
                }
                return "passwordWrong";
            }
        }
        return "notfind";
    }

    @PutMapping("/update")
    public String update(@RequestBody User user){
        User result = userRepository.save(user);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }
}
