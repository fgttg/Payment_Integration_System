package com.cpt.payments.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.cpt.payments.Constant.TransactionStatusEnum;
import com.cpt.payments.Pojo.Transaction;
import com.cpt.payments.Service.Factory.PaymentStatusFactory;
import com.cpt.payments.Service.Impl.Handler.CreatedStatusHandler;
import com.cpt.payments.Service.Interfaces.PaymentStatusHandler;
import com.cpt.payments.Service.Interfaces.PaymentStatusService;
import com.cpt.payments.dto.TransactionDTO;

@Component
public class PaymentStatusServiceImpl implements PaymentStatusService {
	
	@Autowired
	PaymentStatusFactory statusFactory;

	public TransactionDTO processStatus(TransactionDTO txnDto)
	{

		System.out.println("PaymentServiceImpl.processPaymentStatus()"
				+ "||Payment:" +txnDto);
		
		TransactionStatusEnum statusenum = 
							TransactionStatusEnum.getByName(txnDto.getTxnStatusId());
			
		System.out.println("statusenum: "+statusenum);
		
		
		PaymentStatusHandler statushandler = statusFactory.gethandler(statusenum);//Todo inputing perfect status
		
		TransactionDTO processStatusResponse  = statushandler.processStatus(txnDto);
		
		return processStatusResponse; 
	}

}
