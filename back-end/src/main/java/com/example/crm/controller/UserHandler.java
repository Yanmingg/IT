package com.example.crm.controller;

import com.example.crm.entity.*;
import com.example.crm.entity.Exporter;

import com.example.crm.methods.EmailSender;
import com.example.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

import java.io.IOException;


@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;
    private Exporter exporter = new Exporter();

    @Autowired
    private EmailSender emailSender;
    @GetMapping("/findAll")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @PostMapping("/save")
    public Integer save(@RequestBody User user){
        List<User> users = userRepository.findAll();
        for (User user1 : users){
            if (user1.getEmail().equals(user.getEmail())){
                //already exist
                return -1;
            }
        }
        User result = userRepository.save(user);
        if(result!=null){
            //success
            return 1;
        }else{
            //error
            return -2;
        }
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody Email email) throws Exception {
        //emailSender.sendEmails(email.address,email.subject,email.body, email.userAddress, email.userName);
        try {

            String b = emailSender.a;
            //emailSender.sendOneEmail(email.address,email.subject,email.body, email.userAddress, email.userName);
            emailSender.sendEmails(email.address,email.subject,email.body, email.userAddress, email.userName);
            return b;
            //emailSender.sendEmails(email.address, email.subject, email.body, email.userAddress, email.userName);
        }catch (Exception e){
            return e.getMessage();
        }
        //return "sss";

    }

    @PostMapping("/export")
    public void export(@RequestBody List<Contact> contacts) throws IOException {
        exporter.exportContacts(contacts);
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
    public Integer login(@RequestBody Account account){
        List<User> users = userRepository.findAll();
        for (User user : users){
            if (user.getEmail().equals(account.getUseraccount())){
                if(user.getPassword().equals(account.getPassword())) {
                    return user.getId();
                }
                //密码
                return -1;
            }
        }
        //账号
        return -2;
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
