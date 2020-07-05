package com.thoughtworks.movierental;

public class DefaultPriceCode implements PriceCode {
    public double amount(int daysRented) {
        return 0;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return 0;
    }
}