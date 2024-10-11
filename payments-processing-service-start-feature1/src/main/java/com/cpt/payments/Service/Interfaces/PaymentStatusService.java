package com.cpt.payments.Service.Interfaces;


import com.cpt.payments.Pojo.Transaction;
import com.cpt.payments.dto.TransactionDTO;

public interface PaymentStatusService 
{
	public TransactionDTO processStatus(TransactionDTO txnDTO);
}
