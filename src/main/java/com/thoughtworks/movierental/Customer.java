package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private final String name;
  private final List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    double totalAmount = 0;
    int totalFrequentRenterPoints = 0;
    String statement = headerStatement();

    totalFrequentRenterPoints = totalFrequentRenterPoints();

    for (Rental rental : rentals) {
      //show figures for this rental
      statement += "\t" + rental.getMovie().getTitle() + "\t" +
              rental.amount() + "\n";
    }
    totalAmount = totalAmount();

    //add footer lines statement
    statement += "Amount owed is " + totalAmount + "\n";
    statement += "You earned " + totalFrequentRenterPoints
        + " frequent renter points";
    return statement;
  }

  private double totalAmount() {
    double totalAmount = 0;
    for (Rental rental : rentals) {
      totalAmount += rental.amount();
    }
    return totalAmount;
  }

  private int totalFrequentRenterPoints() {
    int totalFrequentRenterPoints = 0;
    for (Rental rental : rentals) {
      totalFrequentRenterPoints += frequentRenterPoints(rental);
    }
    return totalFrequentRenterPoints;
  }

  private int frequentRenterPoints(Rental rental) {
    // add bonus for a two day new release rental
    return ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
            &&
            rental.getDaysRented() > 1) ? 2 : 1;
  }

  private String headerStatement() {
    return "Rental Record for " + name + "\n";
  }
}

