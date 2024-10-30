package com.example.roco_backend.Controller;

import com.example.roco_backend.Pojo.Entity.UserEntity;
import com.example.roco_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public boolean login(@RequestParam String account, @RequestParam String password){
        return userService.login(account, password);
    }

    @GetMapping("/register")
    public boolean register(@RequestParam String account, @RequestParam String password){
        return userService.register(account, password);
    }

    @GetMapping("/name")
    public boolean isExist(@RequestParam String account){
        return userService.isExist(account);
    }

    @PostMapping("/change")
    public void changeInfo(@RequestParam String name, @RequestParam String account){
        userService.changeName(name, account);
    }

}
