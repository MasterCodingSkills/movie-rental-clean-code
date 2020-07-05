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
        return  new RegularPrice().amount(daysRented);
      case Movie.NEW_RELEASE:
        return new NewReleasePrice().amount(daysRented);
      case Movie.CHILDREN:
        return new ChildrenPrice().amount(daysRented);
    }
    return 0;
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