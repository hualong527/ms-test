package com.hualsc.consumer.service;


import com.hualsc.consumer.fallback.UserServiceFallback;
import com.hualsc.provider.service.api.UserServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="USER-PROVIDER",fallback = UserServiceFallback.class)
public interface UserService extends UserServiceApi {
}
