package com.thoughtworks.movierental;

public class BluRayPriceCode implements PriceCode {
    public double amount(int daysRented) {
        return 4*daysRented;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return 3;
    }
}