package com.simple.shoppingcart;

import com.simple.shoppingcart.products.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> products = new ArrayList<>();
    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");
    private  static final BigDecimal TAX_OF_SALES = new BigDecimal("12.5");

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void addProduct(Product product){
        products.add(product);
    }


    public int getQuantity() {
        return products.size();
    }

    public BigDecimal getTotalCost() {
        BigDecimal result = products.stream().map(x->x.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add).add(getAppliedTaxOfSales());
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getAppliedTaxOfSales(){
        return getTaxAmount(getTotalPriceWithNoTax(), TAX_OF_SALES).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal getTaxAmount(BigDecimal base, BigDecimal pct){
        return base.multiply(pct).divide(ONE_HUNDRED);
    }

    private BigDecimal getTotalPriceWithNoTax(){
        return products.stream().map(x->x.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
