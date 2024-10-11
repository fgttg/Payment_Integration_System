package com.cpt.payments.Pojo;

import java.util.List;

import lombok.Data;

@Data
public class InitiatePaymentReq 
{
	private String successUrl;
	
	private String cancelUrl;
	
	private List <LineItem> lineitems;
}
