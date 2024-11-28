package dev.shreya.ecompaymentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/razorpayWebHook   ")
public class RazorpayWebHookController {

    @GetMapping("/")
    public ResponseEntity acceptWebHookRequest(){//called by razorpay
        // redirect to UI with razorpay page
        System.out.println(123);
        return null;
    }
}
