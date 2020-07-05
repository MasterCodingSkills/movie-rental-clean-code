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
    switch (movie.getPriceCode()) {
      case Movie.REGULAR:
        return regularMovieAmount();
      case Movie.NEW_RELEASE:
        return newReleaseMovieAmount();
      case Movie.CHILDREN:
        return childrenMovieAmount();
    }
    return 0;
  }

  private double childrenMovieAmount() {
    double amount = 1.5;
    if (daysRented > 3)
      amount += (daysRented - 3) * 1.5;
    return amount;
  }

  private double newReleaseMovieAmount() {
    return daysRented * 3;
  }

  private double regularMovieAmount() {
    double amount = 2;
    if (daysRented > 2)
      amount += (daysRented - 2) * 1.5;
    return amount;
  }

  int frequentRenterPoints() {
    return isBonusApplicable() ? BONUS_FREQUENT_RENTER_POINTS : DEFAULT_FREQUENT_RENTER_POINTS;
  }

  private boolean isBonusApplicable() {
    return (movie.getPriceCode() == Movie.NEW_RELEASE)
            &&
            daysRented > 1;
  }

}