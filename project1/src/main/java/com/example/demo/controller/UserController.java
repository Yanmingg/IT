package com.example.demo.controller;


import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MarkerHub
 * @since 2021-09-30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Object index(){
        return userService.getById(1L);
    }
}
