package com.cpt.payments.Service.Interfaces;

import com.cpt.payments.Pojo.Transaction;
import com.cpt.payments.dto.TransactionDTO;

public abstract class PaymentStatusHandler {

	public abstract TransactionDTO processStatus(TransactionDTO transaction);
}
