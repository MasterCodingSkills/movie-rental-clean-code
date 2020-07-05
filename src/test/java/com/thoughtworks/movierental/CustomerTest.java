package com.thoughtworks.movierental;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    @Test
    public void shouldGenerateTextStatement(){
        Movie chancePeDance = new Movie("chance pe dance", Movie.CHILDREN);
        Movie don = new Movie("Don", Movie.NEW_RELEASE);
        Movie suryevansham = new Movie("suryevansham", Movie.REGULAR);
        Movie avenger = new Movie("avenger",Movie.BLU_RAY);

        Customer manish = new Customer("Manish");
        manish.addRental(new Rental(chancePeDance, 5));
        manish.addRental(new Rental(don, 10));
        manish.addRental(new Rental(suryevansham,7));
        manish.addRental(new Rental(avenger,1));

        assertThat(manish.statement(),is("Rental Record for Manish\n" +
                "\tchance pe dance\t4.5\n" +
                "\tDon\t30.0\n" +
                "\tsuryevansham\t9.5\n" +
                "\tavenger\t4.0\n" +
                "Amount owed is 48.0\n" +
                "You earned 7 frequent renter points"));
    }

    @Test
    public void shouldGenerateHtmlStatement(){
        Movie chancePeDance = new Movie("chance pe dance", Movie.CHILDREN);
        Movie don = new Movie("Don", Movie.NEW_RELEASE);
        Movie suryevansham = new Movie("suryevansham", Movie.REGULAR);
        Movie avenger = new Movie("avenger",Movie.BLU_RAY);

        Customer manish = new Customer("Manish");
        manish.addRental(new Rental(chancePeDance, 5));
        manish.addRental(new Rental(don, 10));
        manish.addRental(new Rental(suryevansham,7));
        manish.addRental(new Rental(avenger,1));

        assertThat(manish.htmlStatement(),is("<h1>Rental Record for <b>Manish</b></h1>" +
                "chance pe dance 4.5<br>" +
                "Don 30.0<br>" +
                "suryevansham 9.5<br>" +
                "avenger 4.0<br>" +
                "Amount owed is <b>48.0</b><br>" +
                "You earned <b>7</b> frequent renter points"));
    }


}