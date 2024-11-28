package dev.shreya.ecompaymentservice.service;

import dev.shreya.ecompaymentservice.dto.PaymentResponse;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorpay")
public class RajorpayPaymentServiceImpl implements PaymentService {

    private RazorpayClient razorpayClient;

    public RajorpayPaymentServiceImpl(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }
    @Override
    public String doPayment(String email, String phone, Long amount, String orderId) throws RazorpayException {
        try {
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", amount);
           paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("reference_id", orderId);
            JSONObject notes = new JSONObject();
            notes.put("notes_key_1","Tea, Earl Grey, Hot");
           paymentLinkRequest.put("notes",notes);
            JSONObject customer = new JSONObject();
            customer.put("email", email);
            customer.put("contact", phone);
            paymentLinkRequest.put("customer", customer);
//
            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);

            paymentLinkRequest.put("notify", notify);

            paymentLinkRequest.put("callback_url", "http://localhost:8080/razorpayWebHook");
        paymentLinkRequest.put("callback_method", "get");

            PaymentLink response = razorpayClient.paymentLink.create(paymentLinkRequest);
            return response.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
