package dev.shreya.ecompaymentservice.service.startegy;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelectionStrategyImpl implements PaymentGatewaySelectionStrategy{
    @Override
    public int paymentGatewaySelection() {
        return 1;
    }
}