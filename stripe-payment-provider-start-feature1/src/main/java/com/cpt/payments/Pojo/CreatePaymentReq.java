package com.cpt.payments.Pojo;

import java.util.List;

import lombok.Data;

@Data
public class CreatePaymentReq 
{
	private String txnRef;
	
	private String successUrl;
	
	private String cancelUrl;
	
	private List <LineItem> lineitems;
	
}
