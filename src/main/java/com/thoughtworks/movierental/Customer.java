package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private final String name;
  private final Rentals rentals = new Rentals();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String statement() {
    TextStatement textStatement = new TextStatement(name,rentals);
    return textStatement.statement();
  }

  public String htmlStatement() {
    HtmlStatement htmlStatement = new HtmlStatement(name,rentals);
    return htmlStatement.statement();
  }

}

