package com.cpt.payments.Constant;

public enum PaymentProviderEnum {
    STRIPE(1, "STRIPE");

    private final int id;
    private final String providerName;

    // Constructor
    PaymentProviderEnum(int id, String providerName) {
        this.id = id;
        this.providerName = providerName;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Getter for providerName
    public String getProviderName() {
        return providerName;
    }

    // Method to get enum by id
    public static PaymentProviderEnum getByName(String name) {
        for (PaymentProviderEnum provider : values()) {
            if (provider.getProviderName().equals(name)) {
                return provider;
            }
        }
        System.out.println("Invalid PaymentProviderEnum Name | Name: "+ name);
        return null;    
    }
}