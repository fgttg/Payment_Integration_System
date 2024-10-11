package com.cpt.payments.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.Constant.Endpoints;
import com.cpt.payments.Pojo.InitiatePaymentReq;
import com.cpt.payments.Pojo.Transaction;
import com.cpt.payments.Pojo.TransactionResponse;
import com.cpt.payments.Service.Interfaces.PaymentService;
import com.cpt.payments.Service.Interfaces.PaymentStatusService;
import com.cpt.payments.dto.InitiatePaymentReqDTO;
import com.cpt.payments.dto.TransactionDTO;

@RestController
@RequestMapping(Endpoints.V1_PAYMENTS)
public class PaymentController 
{
	private ModelMapper mm;
	
	private PaymentStatusService statusService;
	
	private PaymentService paymentService;
	
	PaymentController(ModelMapper mm, 
			PaymentStatusService statusService, PaymentService paymentService)
	{
		this.mm = mm;
		this.statusService = statusService;
		this.paymentService = paymentService;
	}
	
	@PostMapping(value= {Endpoints.EMPTY_STRING,Endpoints.SLASH})
	public ResponseEntity<TransactionResponse> processRequest(@RequestBody Transaction transaction)
	{	
		System.out.println("****Start Payment Processing**** || Transaction: "+ transaction);
		
		TransactionDTO txnDTO = mm.map(transaction,TransactionDTO.class);

		System.out.println("TransactionDTO Object: "+txnDTO);
		
		TransactionDTO responseDto  = statusService.processStatus(txnDTO);
		
		System.out.println("TestController.createPayment() Checking devtool" + "Transaction: "+transaction+" |ResponseObject:"+responseDto );
		
		
		TransactionResponse responseobj = new TransactionResponse();
		
		responseobj.setId(responseDto.getId());
		responseobj.setTxnStatusId(responseDto.getTxnStatusId());
		
		System.out.println("Returning Response:"+ responseobj);
		
		ResponseEntity<TransactionResponse> responseEntity = new ResponseEntity<>(
															responseobj,HttpStatus.CREATED);
		
		System.out.println("ResponseEntity:"+responseEntity);
		
		return responseEntity;
	}
	
	
	@PostMapping(Endpoints.PAYMENT_INITIATE)
	public ResponseEntity<String> initiatePayment(
			@PathVariable int id, @RequestBody InitiatePaymentReq paymentReq)
	{	
		System.out.println("PaymentController.initiatePayment()||"
				+ "TxnId: "+id+ "|| PaymentReq: "+ paymentReq);
		
		InitiatePaymentReqDTO reqDTO = mm.map(paymentReq,InitiatePaymentReqDTO.class);
		
		reqDTO.setId(id);
		
		System.out.println("Converted RequestObject To DTO:"
				+reqDTO);
		
		String serviceResponse = paymentService.initiatePayment(reqDTO);
		
		System.out.println("Got Resposne From Service Layer ||"
				+ "serviceResponse: " + serviceResponse);
		
		return new ResponseEntity<>(
				"from Controller || " + serviceResponse
				,HttpStatus.OK);
	}
}
