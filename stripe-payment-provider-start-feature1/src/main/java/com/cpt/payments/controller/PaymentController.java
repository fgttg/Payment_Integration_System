package com.cpt.payments.controller;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.Constant.Endpoints;
import com.cpt.payments.Pojo.CreatePaymentReq;
import com.cpt.payments.Pojo.CreatePaymentRes;
import com.cpt.payments.dto.CreatePaymentReqDTO;
import com.cpt.payments.dto.CreatePaymentResDTO;
import com.cpt.payments.service.interfaces.PaymentService;

@RestController
@RequestMapping(Endpoints.V1_PAYMENTS)
public class PaymentController
{
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping(value= {Endpoints.EMPTY_STRING,Endpoints.SLASH})
	public ResponseEntity<CreatePaymentRes> processRequest(@RequestBody 
			         CreatePaymentReq paymentReq)
	{
		System.out.println("PaymentController.processRequest()"
				+ "paymentReq: " + paymentReq);
		
		
		CreatePaymentReqDTO reqDTO = modelMapper.map(paymentReq,CreatePaymentReqDTO.class);
		
		System.out.println("Converted PaymentReq pojo to DTO: reqDTO: "+ reqDTO);
		
		
		CreatePaymentResDTO serviceResDTO = paymentService.processPayment(reqDTO);
		
		CreatePaymentRes finalRes = modelMapper.map(serviceResDTO, CreatePaymentRes.class);

  	    System.out.println("Converted ResponseDTO back to Response POJO|"
  	    		+ " finalres: "+ finalRes);
		
	    return new ResponseEntity<>(finalRes,
	    						HttpStatus.CREATED);
    }
}