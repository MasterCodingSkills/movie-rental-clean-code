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
    return price().amount(daysRented);
  }

  private Price price() {
    switch (movie.getPriceCode()) {
      case Movie.REGULAR:
        return  new RegularPrice();
      case Movie.NEW_RELEASE:
        return new NewReleasePrice();
      case Movie.CHILDREN:
        return new ChildrenPrice();
      default:
        return null;
    }
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