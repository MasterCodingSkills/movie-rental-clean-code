package com.thoughtworks.movierental;

public interface PriceCode {
    double amount(int daysRented);
    int frequentRenterPoints(int daysRented);
}
