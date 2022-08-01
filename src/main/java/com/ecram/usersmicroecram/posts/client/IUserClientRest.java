package com.ecram.usersmicroecram.posts.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service-ecram", path = "/v1/users")
public interface IUserClientRest {

    @GetMapping("/findUserId/{username}")
    ResponseEntity<Long> getUserIdByUsername(@PathVariable String username);
}
