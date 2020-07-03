package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {

    private final String name;
    private final List<Rental> rentals;
    private final double totalAmount;
    private final int totalFrequentRenterPoints;

    public TextStatement(String name, List<Rental> rentals, double totalAmount, int totalFrequentRenterPoints) {
        this.name = name;
        this.rentals = rentals;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
    }

    public String statement() {
        return header() + body() + footer();
    }

    private String body() {
        String statement = "";
        for (Rental rental : rentals) {
            statement += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return statement;
    }

    private String footer() {
        String statement = "";
        statement += "Amount owed is " + totalAmount + "\n";
        statement += "You earned " + totalFrequentRenterPoints
                + " frequent renter points";
        return statement;
    }

    private String header() {
        return "Rental Record for " + name + "\n";
    }
}