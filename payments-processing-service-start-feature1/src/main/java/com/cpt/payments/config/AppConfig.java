package com.cpt.payments.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.entity.TransactionEntity;
import com.cpt.payments.utils.*;

@Configuration
public class AppConfig {

    @Bean
    ModelMapper getModelMapper() {
        ModelMapper modelmapper = new ModelMapper();

        // Converters for converting String to Integer during mapping from DTO to Entity
        Converter<String, Integer> PaymentMethodEnumConverter = new PaymentMethodEnumConverter();
        Converter<String, Integer> paymentTypeEnumConverter = new paymentTypeEnumConverter();
        Converter<String, Integer> ProviderEnumConverter = new ProviderEnumConverter();
        Converter<String, Integer> TxnStatusEnumConverter = new TxnStatusEnumConverter();

        // Reverse Converters for converting Integer to String during mapping from Entity to DTO
        Converter<Integer, String> PaymentMethodEnumReverseConverter = new PaymentMethodEnumReverseConverter();
        Converter<Integer, String> paymentTypeEnumReverseConverter = new PaymentTypeEnumReverseConverter();
        Converter<Integer, String> ProviderEnumReverseConverter = new ProviderEnumReverseConverter();
        Converter<Integer, String> TxnStatusEnumReverseConverter = new TxnStatusEnumReverseConverter();

        // Mapping from TransactionDTO to TransactionEntity
        modelmapper.addMappings(new PropertyMap<TransactionDTO, TransactionEntity>() {
            @Override
            protected void configure() {
                using(PaymentMethodEnumConverter).map(source.getPaymentMethodId(), destination.getPaymentMethodId());
                using(paymentTypeEnumConverter).map(source.getPaymentTypeId(), destination.getPaymentTypeId());
                using(ProviderEnumConverter).map(source.getProviderId(), destination.getProviderId());
                using(TxnStatusEnumConverter).map(source.getTxnStatusId(), destination.getTxnStatusId());
            }
        });

        // Mapping from TransactionEntity to TransactionDTO
        modelmapper.addMappings(new PropertyMap<TransactionEntity, TransactionDTO>() {
            @Override
            protected void configure() {
                using(PaymentMethodEnumReverseConverter).map(source.getPaymentMethodId(), destination.getPaymentMethodId());
                using(paymentTypeEnumReverseConverter).map(source.getPaymentTypeId(), destination.getPaymentTypeId());
                using(ProviderEnumReverseConverter).map(source.getProviderId(), destination.getProviderId());
                using(TxnStatusEnumReverseConverter).map(source.getTxnStatusId(), destination.getTxnStatusId());
            }
        });

        return modelmapper;
    }
}
