package com.simple.shoppingcart.products;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class AxeDeoTest {

    @Test
    public void productAxeDeoShouldHaveNameAndPrice(){
        Product product = new AxeDeo();
        MatcherAssert.assertThat(product.getName(), is (equalTo("Axe Deo")));
        MatcherAssert.assertThat(product.getPrice(), is (equalTo(new BigDecimal("99.99"))));

    }


}