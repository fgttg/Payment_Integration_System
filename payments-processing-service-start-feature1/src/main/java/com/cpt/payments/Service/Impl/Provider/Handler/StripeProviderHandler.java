package com.cpt.payments.Service.Impl.Provider.Handler;

import org.springframework.stereotype.Service;

import com.cpt.payments.Pojo.InitiatePaymentReq;
import com.cpt.payments.Service.Interfaces.ProviderHandler;
import com.cpt.payments.dto.InitiatePaymentReqDTO;
import com.cpt.payments.dto.TransactionDTO;

@Service
public class StripeProviderHandler implements ProviderHandler {

	@Override
	public String processPayment(TransactionDTO txn, InitiatePaymentReqDTO req) {
		
		System.out.println("StripeProviderHandler.processPayment()"
				+"txn: "+ txn
				+"Req: "+req);
		
		
		return "From StripeProviderHandler";
	}
}
