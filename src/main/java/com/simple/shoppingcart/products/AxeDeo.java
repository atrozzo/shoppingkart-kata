package com.simple.shoppingcart.products;

import java.math.BigDecimal;

public class AxeDeo implements Product {


    @Override
    public String getName() {
        return "Axe Deo";
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("99.99");
    }
}
