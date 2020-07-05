package com.thoughtworks.movierental;

public class DefaultPrice implements Price {
    public double amount(int daysRented) {
        return 0;
    }
}