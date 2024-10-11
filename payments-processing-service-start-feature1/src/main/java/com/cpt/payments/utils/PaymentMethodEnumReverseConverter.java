package com.cpt.payments.utils;

import org.modelmapper.AbstractConverter;
import com.cpt.payments.Constant.PaymentMethodEnum;

public class PaymentMethodEnumReverseConverter extends AbstractConverter<Integer, String> {

    @Override
    protected String convert(Integer source) {
        for (PaymentMethodEnum method : PaymentMethodEnum.values()) {
            if (method.getId() == source) {
                return method.getName(); // Assuming getMethodName() returns the string name of the method
            }
        }
        throw new IllegalArgumentException("Invalid Payment Method ID: " + source);
    }
}
