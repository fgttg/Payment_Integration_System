package com.cpt.payments.Pojo;

import lombok.Data;

@Data
public class Transaction {
    private int id;
    private int userId;
    
    private String paymentMethodId;
    private String providerId;
    private String paymentTypeId;
    private String txnStatusId;
    
    private double amount;
    private String currency;
    private String merchantTransactionReference;
    private String txnReference;
    private String providerReference;
    private String providerCode;
    private String providerMessage;
    private int retryCount;

}
