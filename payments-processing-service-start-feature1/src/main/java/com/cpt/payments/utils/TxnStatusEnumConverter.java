package com.cpt.payments.utils;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;

import com.cpt.payments.Constant.PaymentProviderEnum;
import com.cpt.payments.Constant.TransactionStatusEnum;

public class TxnStatusEnumConverter extends AbstractConverter<String,Integer> implements Converter<String, Integer>{

	@Override
	protected Integer convert(String source) {

		return TransactionStatusEnum.getByName(source).getId();
	}
}
