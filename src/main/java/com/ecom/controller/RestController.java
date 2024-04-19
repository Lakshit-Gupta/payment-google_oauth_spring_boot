package com.ecom.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
@org.springframework.web.bind.annotation.RestController
@Controller
    public class RestController {
//    @PostMapping("successfull_payment")
//    public String initiatePayment(@RequestParam("amount") int amount, Model model) {
//        // Here, you could initiate the payment process using Razorpay or another payment gateway
//        // For demonstration purposes, let's just pass the amount to the view
//        model.addAttribute("amount", amount);
//        return "payment_page";


    @GetMapping("/user")
    public Principal user(Principal principal) {
        System.out.println("username : " + principal.getName());
        return principal;
    }

    @GetMapping("/cart")
    public String cart() {
    return "cart";
    }

@PostMapping("/checkout")
public String checkout(){
        return "checkout";


}@GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
