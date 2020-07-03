package com.thoughtworks.movierental;

public class TextStatement {

    private final String name;
    private final Rentals rentals;

    public TextStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
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
        statement += "Amount owed is " + rentals.totalAmount() + "\n";
        statement += "You earned " + rentals.totalFrequentRenterPoints()
                + " frequent renter points";
        return statement;
    }

    private String header() {
        return "Rental Record for " + name + "\n";
    }
}