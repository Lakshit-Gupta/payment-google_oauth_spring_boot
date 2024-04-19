package com.ecom.controller;
import java.io.*;
import java.security.PrivateKey;
import java.util.Map;

//import org.hibernate.mapping.Map;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Order;
@RestController
@RequestMapping("/cart")
public class addtocartController{

    protected String API_KEY_RAZORPAY_KEY_ID ="rzp_test_g8FyyHWRqcqxxX";
    protected String API_KEY_RAZORPAY_KEY_SECRET ="rL17BoNgVHLGdovGEtFjmjSF";
    public String cart(){
    return "Cart";

        }}

