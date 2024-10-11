package com.cpt.payments.service.interfaces;

import org.springframework.stereotype.Service;

import com.cpt.payments.dto.CreatePaymentReqDTO;
import com.cpt.payments.dto.CreatePaymentResDTO;


public interface PaymentService
{
	public CreatePaymentResDTO processPayment(CreatePaymentReqDTO paymentReq);
}
