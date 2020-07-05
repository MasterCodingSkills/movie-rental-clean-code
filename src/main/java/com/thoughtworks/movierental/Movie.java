package com.thoughtworks.movierental;

public class Movie {
  public static final int CHILDREN = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;
  public static final int BLU_RAY = 3;

  private final String title;
  private final int priceCode;

  public Movie(String title, int priceCode) {
    this.title = title;
    this.priceCode = priceCode;
  }

  public int getPriceCode() {
    return priceCode;
  }

  public String getTitle() {
    return title;
  }

   Price price() {
    switch (getPriceCode()) {
      case REGULAR:
        return  new RegularPrice();
      case NEW_RELEASE:
        return new NewReleasePrice();
      case CHILDREN:
        return new ChildrenPrice();
      case BLU_RAY:
        return new BluRayPrice();
      default:
        return new DefaultPrice();
    }
  }

}