package com.warsameegal.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController // Make it a component of spring
@RequestMapping("/user") // map to slash admin
@CrossOrigin("*") // make request across different origins
public class UserController {

    @GetMapping("/")
    public String helloUserController() {
        return "User access level";
    }

}
