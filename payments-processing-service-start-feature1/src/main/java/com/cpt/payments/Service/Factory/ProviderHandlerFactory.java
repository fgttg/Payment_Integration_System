package com.cpt.payments.Service.Factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.cpt.payments.Constant.PaymentProviderEnum;
import com.cpt.payments.Service.Impl.Provider.Handler.StripeProviderHandler;
import com.cpt.payments.Service.Interfaces.ProviderHandler;

@Component
public class ProviderHandlerFactory 
{
	@Autowired
	private ApplicationContext cnxt;
	
	public ProviderHandler getProvider(PaymentProviderEnum providerEnum)
	{
		switch(providerEnum)
		{
			case  STRIPE:
				
					System.out.println("");
					StripeProviderHandler sph = cnxt.getBean(StripeProviderHandler.class);
				
					System.out.println("Got Bean From Applicationm Context"
							+ "StripeProviderHandler bean: "+ sph);
					
					return sph;
					
			default:
			{
				System.out.println("Unable to find Handler");
				return null;
			}
		}
	}

}
