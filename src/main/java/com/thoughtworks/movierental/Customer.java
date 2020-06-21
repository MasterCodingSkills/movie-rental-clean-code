package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

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
    String result = headerStatement();
    for (Rental rental : rentals) {
      totalFrequentRenterPoints += frequentRenterPoints(rental);

      //show figures for this rental
      result += "\t" + rental.getMovie().getTitle() + "\t" +
          String.valueOf(amountFor(rental)) + "\n";
      totalAmount += amountFor(rental);
    }

    //add footer lines result
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(totalFrequentRenterPoints)
        + " frequent renter points";
    return result;
  }

  private int frequentRenterPoints(Rental rental) {
    // add bonus for a two day new release rental
    return ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
            &&
            rental.getDaysRented() > 1) ? 2 : 1;
  }

  private double amountFor(Rental rental) {
    double amount = 0;
    switch (rental.getMovie().getPriceCode()) {
      case Movie.REGULAR:
        amount += 2;
        if (rental.getDaysRented() > 2)
          amount += (rental.getDaysRented() - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        amount += rental.getDaysRented() * 3;
        break;
      case Movie.CHILDRENS:
        amount += 1.5;
        if (rental.getDaysRented() > 3)
          amount += (rental.getDaysRented() - 3) * 1.5;
        break;
    }
    return amount;
  }

  private String headerStatement() {
    return "Rental Record for " + name + "\n";
  }
}

