package dev.shreya.ecompaymentservice.service;

import com.razorpay.RazorpayException;
import dev.shreya.ecompaymentservice.dto.PaymentResponse;

public interface PaymentService {
    String doPayment(String email, String phone, Long amount, String orderId) throws RazorpayException;
}
