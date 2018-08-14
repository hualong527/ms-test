package com.hualsc.provider.controller;

import com.hualsc.provider.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserContorller {

    @Value("${server.port}")
    private String port;

    @RequestMapping("getUser")
    public User getUserInfo(@RequestParam("id") Long id){
        User user = new User();
        user.setId(id);
        user.setName("test:"+port);
        return user;
    }
}
