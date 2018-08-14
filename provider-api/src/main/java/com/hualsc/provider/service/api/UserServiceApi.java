package com.hualsc.provider.service.api;

import com.hualsc.provider.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface UserServiceApi {

    @RequestMapping("user/getUser")
    public User getUserInfo(@RequestParam("id") Long id);
}
