package com.thoughtworks.movierental;

public class NewReleasePrice implements Price {
    public double amount(int daysRented) {
        return daysRented * 3;
    }
}