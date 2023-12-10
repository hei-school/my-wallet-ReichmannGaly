package com.prog5.items;

public class IDCard {
    private String owner;
    private String cardNumber;

    private boolean isLost;

    public IDCard(String owner, String cardNumber, boolean isLost) {
        this.owner = owner;
        this.cardNumber = cardNumber;
        this.isLost = isLost;
    }

    @Override
    public String toString() {
        return "\nIDCard: " +
                "\nowner: " + owner +
                ", cardNumber: " + cardNumber +
                ", isLost: " + isLost;
    }
}
