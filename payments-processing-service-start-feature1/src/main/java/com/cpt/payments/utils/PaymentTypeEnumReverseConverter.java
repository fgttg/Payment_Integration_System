package com.cpt.payments.utils;

import org.modelmapper.AbstractConverter;
import com.cpt.payments.Constant.PaymentTypeEnum;

public class PaymentTypeEnumReverseConverter extends AbstractConverter<Integer, String> {

    @Override
    protected String convert(Integer source) {
        for (PaymentTypeEnum type : PaymentTypeEnum.values()) {
            if (type.getId() == source) {
                return type.getType(); // Assuming getType() returns the string name of the type
            }
        }
        throw new IllegalArgumentException("Invalid Payment Type ID: " + source);
    }
}
