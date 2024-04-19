package com.ecom.controller;
import com.razorpay.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.razorpay.Order;
import com.google.gson.Gson;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.ecom.model.Customer;
import com.ecom.model.RazorPay;
import com.ecom.model.Response;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PaymentController {




public void Create_order() throws RazorpayException{


        RazorpayClient razorpay = new RazorpayClient("rzp_test_g8FyyHWRqcqxxX", "rL17BoNgVHLGdovGEtFjmjSF");
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", 50000);
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "receipt#1");
        JSONObject notes = new JSONObject();
        notes.put("notes_key_1", "Tea, Earl Grey, Hot");
        notes.put("notes_key_1", "Tea, Earl Grey, Hot");
        orderRequest.put("notes", notes);

        Order order = razorpay.orders.create(orderRequest);
    }

    }


