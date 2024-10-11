package com.cpt.payments.service.impl;

import org.springframework.stereotype.Service;

import com.cpt.payments.Pojo.CreatePaymentRes;

import com.cpt.payments.dto.CreatePaymentReqDTO;
import com.cpt.payments.dto.CreatePaymentResDTO;
import com.cpt.payments.service.interfaces.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Override
	public CreatePaymentResDTO processPayment(CreatePaymentReqDTO paymentReq)
	{
		System.out.println("PaymentServiceImpl.processPayment()");
		
		CreatePaymentResDTO responseobj = CreatePaymentResDTO.builder()
				.id("Unique Generated Id")
				.redirectUrl("http://stripe-redirect-url.com")
				.build();
				 
        System.out.println("ResponseObject: "+ responseobj);
			    
		return responseobj;
	}
}
