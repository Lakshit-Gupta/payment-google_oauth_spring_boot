package com.ecom.controller;


import java.math.BigDecimal;
import java.math.RoundingMode;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

@Controller
public class Razor_pay_controller_ex1 {

    private RazorpayClient client;
    private static Gson gson = new Gson();

    /**
     * add your secretId and secretValue you got from your RazorPay account.
     */
    private static final String SECRET_ID = "rzp_test_g8FyyHWRqcqxxX";
    private static final String SECRET_KEY = "rL17BoNgVHLGdovGEtFjmjSF";

    public Home() throws RazorpayException {
        this.client =  new RazorpayClient(SECRET_ID, SECRET_KEY);
    }

    @RequestMapping(value="/")
    public String getHome() {
        return "redirect:/home";
    }
    @RequestMapping(value="/checkout")
    public String getHomeInit() {
        return "checkout";
    }

    @RequestMapping(value="/w", method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> createOrder(@RequestBody Customer customer) {

        try {

            /**
             * creating an order in RazorPay.
             * new order will have order id. you can get this order id by calling  order.get("id")
             */
            Order order = createRazorPayOrder( customer.getAmount() );
            RazorPay razorPay = getRazorPay((String)order.get("id"), customer);

            return new ResponseEntity<String>(gson.toJson(getResponse(razorPay, 200)),
                    HttpStatus.OK);
        } catch (RazorpayException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(gson.toJson(getResponse(new RazorPay(), 500)),
                HttpStatus.EXPECTATION_FAILED);
    }

    private Response getResponse(RazorPay razorPay, int statusCode) {
        Response response = new Response();
        response.setStatusCode(statusCode);
        response.setRazorPay(razorPay);
        return response;
    }

    private RazorPay getRazorPay(String orderId, Customer customer) {
        RazorPay razorPay = new RazorPay();
        razorPay.setApplicationFee(convertRupeeToPaise(customer.getAmount()));
        razorPay.setCustomerName(customer.getCustomerName());
        razorPay.setCustomerEmail(customer.getEmail());
        razorPay.setMerchantName("Test");
        razorPay.setPurchaseDescription("TEST PURCHASES");
        razorPay.setRazorpayOrderId(orderId);
        razorPay.setSecretKey(SECRET_ID);
        razorPay.setImageURL("/logo");
        razorPay.setTheme("#F37254");
        razorPay.setNotes("notes"+orderId);

        return razorPay;
    }

    private Order createRazorPayOrder(String amount) throws RazorpayException {

        JSONObject options = new JSONObject();
        options.put("amount", convertRupeeToPaise(amount));
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");
        options.put("payment_capture", 1); // You can enable this if you want to do Auto Capture.
        return client.orders.create(options);
    }

    private String convertRupeeToPaise(String paise) {
        BigDecimal b = new BigDecimal(paise);
        BigDecimal value = b.multiply(new BigDecimal("100"));
        return value.setScale(0, RoundingMode.UP).toString();

    }


}
