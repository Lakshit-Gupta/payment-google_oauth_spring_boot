package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller

public class OAuthController {

    @GetMapping("/oauth-success")
    public String oauthSuccess(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        // Add more attributes as needed for other user information
        return "oauth-success"; // This corresponds to the name of your Thymeleaf template file
    }


}
