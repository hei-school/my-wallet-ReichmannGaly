package com.prog5.items;

public class Money {
    public enum Currency{
        Dollars, Euro, Ariary
    }

    private Currency currency;

    private double amount;

    public Money(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "\nMoney: " +
                "\ncurrency: " + currency +
                ", amount: " + amount;
    }
}
