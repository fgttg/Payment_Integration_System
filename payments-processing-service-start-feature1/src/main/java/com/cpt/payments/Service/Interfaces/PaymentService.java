package com.cpt.payments.Service.Interfaces;

import com.cpt.payments.dto.InitiatePaymentReqDTO;

public interface PaymentService 
{
	public String initiatePayment(InitiatePaymentReqDTO req);
}
