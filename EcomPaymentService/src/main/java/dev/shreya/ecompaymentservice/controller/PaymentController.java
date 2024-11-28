package dev.shreya.ecompaymentservice.controller;

import com.razorpay.RazorpayException;
import dev.shreya.ecompaymentservice.dto.InitiatePaymentRequestDto;
import dev.shreya.ecompaymentservice.dto.PaymentResponse;
import dev.shreya.ecompaymentservice.service.PaymentService;
import dev.shreya.ecompaymentservice.service.startegy.PaymentGatewaySelectionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
//@Autowired-field injection either use autowired or do constructor injection
private PaymentService razorpayPaymentService;
    private PaymentService stripePaymentService;

    private PaymentGatewaySelectionStrategy paymentGatewaySelectionStrategy;
    public PaymentController(
            @Qualifier("razorpay") PaymentService razorpayPaymentService,
            @Qualifier("stripe") PaymentService stripePaymentService,
            PaymentGatewaySelectionStrategy paymentGatewaySelectionStrategy) {
        this.razorpayPaymentService = razorpayPaymentService;
        this.stripePaymentService = stripePaymentService;
        this.paymentGatewaySelectionStrategy = paymentGatewaySelectionStrategy;
    }
    @PostMapping("/payment")
    public String intiatePayment(@RequestBody InitiatePaymentRequestDto requestDto) throws RazorpayException {
        int paymentGatewayOption = choosePaymentGateway();
        switch (paymentGatewayOption){
            case 1 : return razorpayPaymentService.doPayment(requestDto.getEmail(), requestDto.getPhoneNumber(), requestDto.getAmount(), requestDto.getOrderId());
            case 2 : return stripePaymentService.doPayment(requestDto.getEmail(), requestDto.getPhoneNumber(), requestDto.getAmount(), requestDto.getOrderId());
        }
        return null;
    }
    private int choosePaymentGateway(){
        //add your logic to choose the payment gateway
        return paymentGatewaySelectionStrategy.paymentGatewaySelection();
       // return 1;
    }
}
