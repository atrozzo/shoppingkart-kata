package com.simple.shoppingcart.products;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class DoveSoapTest {

    @Test
    public void productDoveSoapShouldHaveNameAndPrice(){
        Product product = new DoveSoap();
        MatcherAssert.assertThat(product.getName(), is (equalTo("Dove Soap")));
        MatcherAssert.assertThat(product.getPrice(), is (equalTo(new BigDecimal("39.99"))));
    }



}