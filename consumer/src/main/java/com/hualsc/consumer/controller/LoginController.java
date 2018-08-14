package com.hualsc.consumer.controller;

import com.hualsc.consumer.service.UserService;
import com.hualsc.provider.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("check")
    public Boolean checkUser(@RequestParam("id") Long id,@RequestParam("name") String name){
        User user = userService.getUserInfo(id);
        if(user.getName().equals(name)){
            return true;
        }else{
            return false;
        }
    }
}
