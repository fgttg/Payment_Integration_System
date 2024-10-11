package com.cpt.payments.Service.Interfaces;

import com.cpt.payments.Pojo.InitiatePaymentReq;
import com.cpt.payments.dto.InitiatePaymentReqDTO;
import com.cpt.payments.dto.TransactionDTO;

public interface ProviderHandler 
{
	public String processPayment(TransactionDTO txn, InitiatePaymentReqDTO req);

}
