package com.cpt.payments.Pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InitiatePaymentRes 
{
	private String id;
	
	private String redirectUrl;

}
