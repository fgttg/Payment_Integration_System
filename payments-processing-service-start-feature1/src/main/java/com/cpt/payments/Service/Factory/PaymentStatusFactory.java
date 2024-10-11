package com.cpt.payments.Service.Factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.cpt.payments.Constant.TransactionStatusEnum;
import com.cpt.payments.Service.Impl.Handler.CreatedStatusHandler;
import com.cpt.payments.Service.Interfaces.PaymentStatusHandler;

@Component
public class PaymentStatusFactory 
{
	@Autowired
	private ApplicationContext context;
	
	public PaymentStatusHandler gethandler(TransactionStatusEnum statusenum)
	{
		switch(statusenum)
		{
		 case CREATED:
		 {
				System.out.println("Creating CreateStatusHandler for "
						+ "status: "+ statusenum);
				
				CreatedStatusHandler csh =context.getBean(CreatedStatusHandler.class);
				
				System.out.println("Got Bean from Application Context"
						+ "|| statusHandler: "+csh);
				
				return csh;
			}
		default:
			{
				System.out.println("Unable to find Handler");
				return null;
			}
		}
	}
}
	