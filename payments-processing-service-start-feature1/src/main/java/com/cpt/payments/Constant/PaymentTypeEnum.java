package com.cpt.payments.Constant;

public enum PaymentTypeEnum {
    SALE(1, "SALE");

    private final int id;
    private final String type;

    // Constructor
    PaymentTypeEnum(int id, String type) {
        this.id = id;
        this.type = type;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Method to get enum by id
    public static PaymentTypeEnum getByName(String type ) {
        for (PaymentTypeEnum paymentType : values()) {
            if (paymentType.getType().equals(type)) {
                return paymentType;
            }
        }
        System.out.println("Invalid PaymentType | Type: "+ type);
        return null; 
    }
}

