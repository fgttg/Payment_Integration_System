package com.cpt.payments.utils;

import org.modelmapper.AbstractConverter;
import com.cpt.payments.Constant.PaymentProviderEnum;

public class ProviderEnumReverseConverter extends AbstractConverter<Integer, String> {

    @Override
    protected String convert(Integer source) {
        for (PaymentProviderEnum provider : PaymentProviderEnum.values()) {
            if (provider.getId() == source) {
                return provider.getProviderName(); // Assuming getProviderName() returns the string name of the provider
            }
        }
        throw new IllegalArgumentException("Invalid Provider ID: " + source);
    }
}

