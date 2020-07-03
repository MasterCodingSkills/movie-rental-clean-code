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

  public String statement() {
    TextStatement textStatement = new TextStatement(name,rentals,totalAmount(),totalFrequentRenterPoints());
    return textStatement.statement();
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
      totalFrequentRenterPoints += rental.frequentRenterPoints();
    }
    return totalFrequentRenterPoints;
  }

  public String htmlStatement() {
    HtmlStatement htmlStatement = new HtmlStatement(name,rentals,totalAmount(),totalFrequentRenterPoints());
    return htmlStatement.htmlStatement();
  }

}

