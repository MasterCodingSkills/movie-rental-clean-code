package com.thoughtworks.movierental;

public class NewReleasePriceCode implements PriceCode {
    public static final int BONUS_FREQUENT_RENTER_POINTS = 2;
    public static final int DEFAULT_FREQUENT_RENTER_POINTS = 1;

    public double amount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return isBonusApplicable(daysRented) ? BONUS_FREQUENT_RENTER_POINTS : DEFAULT_FREQUENT_RENTER_POINTS;
    }

    private boolean isBonusApplicable(int daysRented) {
        return daysRented > 1;
    }
}