package com.okta.helloworld.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping({"/", "hello"})
    public String helloWorld(Model model, @AuthenticationPrincipal OidcUser user) {
        model.addAttribute("name", user.getGivenName());
        return "hello-world";
    }

}
