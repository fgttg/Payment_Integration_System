package com.cpt.payments.Constant;

public enum TransactionStatusEnum {
    CREATED(1, "CREATED"),
    INITIATED(2, "INITIATED"),
    PENDING(3, "PENDING"),
    SUCCESS(4, "SUCCESS"),
    FAILED(5, "FAILED");

    private final int id;
    private final String name;

    // Constructor
    TransactionStatusEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Method to get enum by Name
    public static TransactionStatusEnum getByName(String name) {
        for (TransactionStatusEnum status : values()) {
            if (status.getName().equals(name)) {
                return status;
            }
        }
        System.out.println("No TransactionStatusEnum is there for the Name: "+ name);
        return null;    }
}
