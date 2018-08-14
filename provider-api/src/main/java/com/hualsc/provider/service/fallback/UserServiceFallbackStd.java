package com.hualsc.provider.service.fallback;

import com.hualsc.provider.entity.User;
import com.hualsc.provider.service.api.UserServiceApi;

public class UserServiceFallbackStd implements UserServiceApi {
    @Override
    public User getUserInfo(Long id) {
        User user = new User();
        user.setId(0L);
        user.setName("null");
        return user;
    }
}
