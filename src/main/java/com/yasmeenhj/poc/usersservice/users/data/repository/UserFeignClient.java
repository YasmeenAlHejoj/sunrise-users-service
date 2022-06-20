package com.yasmeenhj.poc.usersservice.users.data.repository;



//@FeignClient(value = "accounting-service")
public interface UserFeignClient {
     void getAccountsByUserId();
}
