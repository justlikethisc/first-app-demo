package com.example.firstappdemo.controller;

import com.example.firstappdemo.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/user/save")
    private User save(@RequestParam String name){
        User user = new User();
        user.setId(1);
        user.setName(name);
        System.out.println("新增用户成功："  + user);
        return user;
    }
}
