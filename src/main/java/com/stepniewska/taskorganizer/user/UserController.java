package com.stepniewska.taskorganizer.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/register")
    public String getCredentials(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String result = authentication.getName();
        return result;
    }



    @PostMapping("/register")
    public User registerUser(@RequestBody @Valid User user){
        return userService.registerUser(user);
    }

}
