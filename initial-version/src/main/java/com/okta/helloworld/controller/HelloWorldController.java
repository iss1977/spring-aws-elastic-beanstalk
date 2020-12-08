package com.okta.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class HelloWorldController {

    @GetMapping({"/", "hello"})
    public String helloWorld(@RequestParam(required = false, defaultValue = "World") String name, Model model, Principal principal) {
        model.addAttribute("name", principal.getName());
        System.out.println("@GetMapping({\"/\", \"hello\"}) did just run...");
        return "hello-world";
    }

}
