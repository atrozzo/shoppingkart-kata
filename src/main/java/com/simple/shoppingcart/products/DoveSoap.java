package com.simple.shoppingcart.products;

import java.math.BigDecimal;

public class DoveSoap implements Product{


    @Override
    public String getName() {
        return "Dove Soap";
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("39.99");
    }
}
