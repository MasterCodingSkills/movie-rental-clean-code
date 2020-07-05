package com.thoughtworks.movierental;

public class HtmlStatement {

    private final String name;
    private final Rentals rentals;

    public HtmlStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String statement() {
        return header() + body() + footer();
    }

    private String body() {
        StringBuilder statement = new StringBuilder();
        for (Rental rental : rentals) {
            statement.append(rental.getMovie().getTitle()).append(" ").append(rental.amount()).append("<br>");
        }
        return statement.toString();
    }

    String footer() {
        String statement = "";
        statement += "Amount owed is <b>" + rentals.totalAmount() + "</b><br>";
        statement += "You earned <b>" + rentals.totalFrequentRenterPoints()
                + "</b> frequent renter points";
        return statement;
    }

    String header() {
        return "<h1>Rental Record for <b>" + name + "</b></h1>";
    }
}