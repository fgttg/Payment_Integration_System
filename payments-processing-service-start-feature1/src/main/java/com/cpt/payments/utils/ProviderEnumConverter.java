package com.cpt.payments.utils;

import org.modelmapper.AbstractConverter;

import com.cpt.payments.Constant.PaymentMethodEnum;
import com.cpt.payments.Constant.PaymentProviderEnum;

public class ProviderEnumConverter extends AbstractConverter<String,Integer>{

	@Override
	protected Integer convert(String source) {
		
		return PaymentProviderEnum.getByName(source).getId();
	}
}
