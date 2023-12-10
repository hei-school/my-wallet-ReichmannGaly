package com.prog5.items;

public class BusinessCard {
    private String ownerName;

    private String companyName;

    public BusinessCard(String ownerName, String companyName) {
        this.ownerName = ownerName;
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "\nBusinessCard:" +
                "\nownerName: " + ownerName +
                ", companyName: " + companyName;
    }
}
