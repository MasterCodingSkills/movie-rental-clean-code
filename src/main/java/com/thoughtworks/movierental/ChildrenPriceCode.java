package com.thoughtworks.movierental;

public class ChildrenPriceCode implements PriceCode {
    public double amount(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return 1;
    }
}