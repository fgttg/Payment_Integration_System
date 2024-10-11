package com.cpt.payments.dto;

import java.util.List;

import lombok.Data;

@Data
public class CreatePaymentReqDTO 
{
	private String txnRef;
	
	private String successUrl;
	
	private String cancelUrl;
	
	private List <LineItemDTO> lineitems;
	
}
