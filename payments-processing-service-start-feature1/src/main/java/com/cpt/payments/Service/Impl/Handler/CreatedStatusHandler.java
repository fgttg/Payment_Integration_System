package com.cpt.payments.Service.Impl.Handler;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.cpt.payments.Pojo.Transaction;
import com.cpt.payments.Service.Interfaces.PaymentStatusHandler;
import com.cpt.payments.dao.impl.TransactionDaoimpl;
import com.cpt.payments.dao.interfaces.TransactionDao;
import com.cpt.payments.dto.TransactionDTO;

@Component
public class CreatedStatusHandler extends PaymentStatusHandler{

	@Autowired
	private TransactionDao txnDao;
	
	public TransactionDTO processStatus(TransactionDTO txnDto)
	{
		System.out.println("CreatedStatusHandler.processStatus()||"
				+ "Payment: "+ txnDto);
		
		TransactionDTO txnCreatedResponse = txnDao.createTransaction(txnDto);
		
		System.out.println("Received below response from DAO || "
				+ "txnCreatedResponse: "+ txnCreatedResponse);
		
		return txnCreatedResponse;
	}
}
