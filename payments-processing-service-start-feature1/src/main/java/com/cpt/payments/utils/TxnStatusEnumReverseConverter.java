package com.cpt.payments.utils;

import org.modelmapper.AbstractConverter;

import com.cpt.payments.Constant.TransactionStatusEnum;

public class TxnStatusEnumReverseConverter extends AbstractConverter<Integer, String> {

    @Override
    protected String convert(Integer source) {
        for (TransactionStatusEnum status : TransactionStatusEnum.values()) {
            if (status.getId() == source) {
                return status.getName(); // Assuming getStatusName() returns the string name of the status
            }
        }
        throw new IllegalArgumentException("Invalid Transaction Status ID: " + source);
    }
}

