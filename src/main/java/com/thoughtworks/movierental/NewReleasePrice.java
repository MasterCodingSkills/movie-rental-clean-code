package com.thoughtworks.movierental;

public class NewReleasePrice {
    double amount(int daysRented) {
        return daysRented * 3;
    }
}