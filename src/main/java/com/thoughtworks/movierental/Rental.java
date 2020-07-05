package com.thoughtworks.movierental;

public class Rental {

  public static final int BONUS_FREQUENT_RENTER_POINTS = 2;
  public static final int DEFAULT_FREQUENT_RENTER_POINTS = 1;
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
    double amount = 0;
    switch (movie.getPriceCode()) {
      case Movie.REGULAR:
        amount += 2;
        if (daysRented > 2)
          amount += (daysRented - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        amount += daysRented * 3;
        break;
      case Movie.CHILDREN:
        amount += 1.5;
        if (daysRented > 3)
          amount += (daysRented - 3) * 1.5;
        break;
    }
    return amount;
  }

  int frequentRenterPoints() {
    // add bonus for a two day new release rental
    return ((movie.getPriceCode() == Movie.NEW_RELEASE)
            &&
            daysRented > 1) ? BONUS_FREQUENT_RENTER_POINTS : DEFAULT_FREQUENT_RENTER_POINTS;
  }
}