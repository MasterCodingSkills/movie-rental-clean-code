package com.thoughtworks.movierental;

import java.util.List;

public class HtmlStatement {

    private final String name;
    private final List<Rental> rentals;
    private final double totalAmount;
    private final int totalFrequentRenterPoints;

    public HtmlStatement(String name, List<Rental> rentals, double totalAmount, int totalFrequentRenterPoints) {
        this.name = name;
        this.rentals = rentals;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
    }

    public String htmlStatement() {
        return header() + body() + footer();
    }

    private String body() {
        String statement = "";
        for (Rental rental : rentals) {
            statement +=  rental.getMovie().getTitle()  +" "+
                    rental.amount() + "<br>";
        }
        return statement;
    }

    String footer() {
        String statement = "";
        statement += "Amount owed is <b>" + totalAmount + "</b><br>";
        statement += "You earned <b>" + totalFrequentRenterPoints
                + "</b> frequent renter points";
        return statement;
    }

    String header() {
        return "<h1>Rental Record for <b>" + name + "</b></h1>";
    }
}