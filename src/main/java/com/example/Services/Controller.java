package com.example.Services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping({"/Welcome"})
    public String Welcome(){
        return "Welcome";
    }
}
