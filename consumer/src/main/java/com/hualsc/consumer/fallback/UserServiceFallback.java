package com.hualsc.consumer.fallback;

import com.hualsc.consumer.service.UserService;
import com.hualsc.provider.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserService {
    @Override
    public User getUserInfo(Long id) {
        User user = new User();
        user.setId(0L);
        user.setName("null");
        return user;
    }
}
