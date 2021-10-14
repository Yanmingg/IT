package com.example.crm.controller;

import com.example.crm.entity.Account;
import com.example.crm.entity.User;
import com.example.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

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
            if (user.getEmail().toLowerCase().equals(account.getUseraccount().toLowerCase())){
                System.out.println(user.getEmail());
                return "find";
            }
        }
        return "notfind";
    }
}
