package com.thoughtworks.movierental;

public class Rental {

  private final int daysRented;
  private final Movie movie;

  public Rental(Movie movie, int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public double amount() {
    return movie.priceCode().amount(daysRented);
  }

  int frequentRenterPoints() {
    return movie.priceCode().frequentRenterPoints(daysRented);
  }

}