package com.prog5.items;

import java.time.LocalDate;

public class CreditCard {
    private String owner;

    private String cardNumber;

    private LocalDate expirationDate;

    public CreditCard(String owner, String cardNumber, LocalDate expirationDate) {
        this.owner = owner;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "\nCreditCard: " +
                "\nowner: " + owner +
                ", cardNumber: " + cardNumber +
                ", expirationDate: " + expirationDate;
    }
}
