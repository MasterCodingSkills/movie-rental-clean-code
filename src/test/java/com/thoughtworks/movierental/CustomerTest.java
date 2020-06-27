package com.thoughtworks.movierental;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    @Test
    public void shouldGenerateTextStatement(){
        Movie chancePeDance = new Movie("chance pe dance", Movie.CHILDRENS);
        Movie don = new Movie("Don", Movie.NEW_RELEASE);
        Movie suryevansham = new Movie("suryevansham", Movie.REGULAR);

        Customer manish = new Customer("Manish");
        manish.addRental(new Rental(chancePeDance, 5));
        manish.addRental(new Rental(don, 10));
        manish.addRental(new Rental(suryevansham,7));

        assertThat(manish.statement(),is("Rental Record for Manish\n" +
                "\tchance pe dance\t4.5\n" +
                "\tDon\t30.0\n" +
                "\tsuryevansham\t9.5\n" +
                "Amount owed is 44.0\n" +
                "You earned 4 frequent renter points"));
    }

    @Test
    public void shouldGenerateHtmlStatement(){
        Movie chancePeDance = new Movie("chance pe dance", Movie.CHILDRENS);
        Movie don = new Movie("Don", Movie.NEW_RELEASE);
        Movie suryevansham = new Movie("suryevansham", Movie.REGULAR);

        Customer manish = new Customer("Manish");
        manish.addRental(new Rental(chancePeDance, 5));
        manish.addRental(new Rental(don, 10));
        manish.addRental(new Rental(suryevansham,7));

        assertThat(manish.htmlStatement(),is("<h1>Rental Record for <b>Manish</b></h1>" +
                "chance pe dance 4.5<br>" +
                "Don 30.0<br>" +
                "suryevansham 9.5<br>" +
                "Amount owed is <b>44.0</b><br>" +
                "You earned <b>4</b> frequent renter points"));
    }


}