package com.bearnrabbit.coffeeorder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @GetMapping("/")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

}
