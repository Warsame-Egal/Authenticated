package com.warsameegal.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    public String helloUserController() {
        return "User access level";
    }

}
