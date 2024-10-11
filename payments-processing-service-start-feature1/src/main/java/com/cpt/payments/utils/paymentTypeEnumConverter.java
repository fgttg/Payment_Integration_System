package com.cpt.payments.utils;

import org.modelmapper.AbstractConverter;

import com.cpt.payments.Constant.PaymentMethodEnum;
import com.cpt.payments.Constant.PaymentTypeEnum;

public class paymentTypeEnumConverter extends AbstractConverter<String,Integer>{

	@Override
	protected Integer convert(String source) {
		
		return PaymentTypeEnum.getByName(source).getId();
	}
}
