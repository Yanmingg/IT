package com.example.crm.controller;

import com.example.crm.entity.*;
import com.example.crm.methods.EmailSender;
import com.example.crm.entity.Exporter;
import com.example.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.mail.MessagingException;
import java.io.IOException;


@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;
    private EmailSender emailSender = new EmailSender();
    private Exporter exporter = new Exporter();
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
            emailSender.sendEmails(email.address,email.subject,email.body, email.userAddress, email.userName);
        }catch (MessagingException e){
            return "fail";
        }
        return "successful";
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
                    return 0;
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
