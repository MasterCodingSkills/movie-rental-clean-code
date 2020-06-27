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
    return headerStatement() + bodyStatement() + footerStatement();
  }

  private String bodyStatement() {
    String statement = "";
    for (Rental rental : rentals) {
      statement += "\t" + rental.getMovie().getTitle() + "\t" +
              rental.amount() + "\n";
    }
    return statement;
  }

  private String footerStatement() {
    String statement = "";
    statement += "Amount owed is " + totalAmount() + "\n";
    statement += "You earned " + totalFrequentRenterPoints()
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
      totalFrequentRenterPoints += rental.frequentRenterPoints();
    }
    return totalFrequentRenterPoints;
  }

  public String htmlStatement() {
    return headerHtml() + bodyHtml() + footerHtml();
  }

  private String bodyHtml() {
    String statement = "";
    for (Rental rental : rentals) {
      statement +=  rental.getMovie().getTitle()  +" "+
              rental.amount() + "<br>";
    }
    return statement;
  }

  private String footerHtml() {
    String statement = "";
    statement += "Amount owed is <b>" + totalAmount() + "</b><br>";
    statement += "You earned <b>" + totalFrequentRenterPoints()
            + "</b> frequent renter points";
    return statement;
  }

  private String headerHtml() {
    return "<h1>Rental Record for <b>" + name +"</b></h1>";
  }

  private String headerStatement() {
    return "Rental Record for " + name + "\n";
  }
}

