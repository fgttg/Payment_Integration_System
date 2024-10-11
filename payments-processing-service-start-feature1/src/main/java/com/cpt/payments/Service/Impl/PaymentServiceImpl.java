package com.cpt.payments.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.payments.Constant.PaymentProviderEnum;
import com.cpt.payments.Service.Factory.ProviderHandlerFactory;
import com.cpt.payments.Service.Interfaces.PaymentService;
import com.cpt.payments.Service.Interfaces.ProviderHandler;
import com.cpt.payments.dao.impl.TransactionDaoimpl;
import com.cpt.payments.dao.interfaces.TransactionDao;
import com.cpt.payments.dto.InitiatePaymentReqDTO;
import com.cpt.payments.dto.TransactionDTO;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private TransactionDao transactiondao;
	
	@Autowired
	private ProviderHandlerFactory phf;
	
	
	@Override
	public String initiatePayment(InitiatePaymentReqDTO req) 
	{
		System.out.println("PaymentServiceImpl.initiatePayment() || "
				+ "ReqDTO: "+ req);
		
		TransactionDTO transactioDTO = transactiondao.getTransactionById(req.getId()); 
		
		System.out.println("Get the TransactionDTO from Dao Layer: || "
				+ "transactioDTO: "+ transactioDTO);
		
		//System.out.println("Transactiondto Providerid: "+transactioDTO.getProviderId() );
		
		ProviderHandler ph = phf.getProvider(PaymentProviderEnum.getByName(transactioDTO.getProviderId()));
		
		String providerResponse = ph.processPayment(transactioDTO, req);
		
		System.out.println("Got Response from Provider "
				+ "providerResponse: "+ providerResponse);
		
		
		return "From PaymentServiceImpl " + providerResponse;
	}
}
