package com.cpt.payments.Constant;

public enum PaymentMethodEnum {
    APM(1, "APM");

    private final int id;
    private final String name;

    // Constructor
    PaymentMethodEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Getter for apm
    public String getName() {
        return name;
    }

    // Method to get enum by id
    public static PaymentMethodEnum getByName(String name) {
        for (PaymentMethodEnum method : values()) {
            if (method.getName().equals(name)) {
                return method;
            }
        }
        System.out.println("Invalid PaymentMethodEnum Name | name: "+ name);
        return null; 
    }
}

