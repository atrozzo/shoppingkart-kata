package com.simple.shoppingcart;


import com.simple.shoppingcart.products.AxeDeo;
import com.simple.shoppingcart.products.DoveSoap;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;


public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @BeforeEach
    public void setup(){
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void shoppingCartShouldExist(){
        MatcherAssert.assertThat(shoppingCart, is (notNullValue()));
    }

    @Test
    public void shoppingCartShouldBeEmpty(){
        MatcherAssert.assertThat(shoppingCart.isEmpty(), is (true));
    }

    @Test
    public void shouldBeAbleToAddProductToShoppingCart(){
        shoppingCart.addProduct(new DoveSoap());
        MatcherAssert.assertThat(shoppingCart.isEmpty(), is (false));
    }

    @Test
    public void shouldBeAbleToGetProductTotalPriceForFiveDoveSoapInTheShoppingCart(){
        for (int i = 0 ;i<5;i++){
            shoppingCart.addProduct(new DoveSoap());
        }
        MatcherAssert.assertThat(shoppingCart.isEmpty(), is (false));
        MatcherAssert.assertThat(shoppingCart.getQuantity(), is (5));
        MatcherAssert.assertThat(shoppingCart.getTotalCost(),
                is (equalTo( new BigDecimal("224.94").setScale(2, RoundingMode.HALF_UP))));

    }

    @Test
    public void shouldBeAbleToGetProductTotalPriceFor8DoveSoapProductsInTheShoppingCart(){
        // Add first 5 products
        for (int i = 0 ;i<5;i++){
            shoppingCart.addProduct(new DoveSoap());
        }
        // Lest add 3 more
        shoppingCart.addProduct(new DoveSoap());
        shoppingCart.addProduct(new DoveSoap());
        shoppingCart.addProduct(new DoveSoap());

        MatcherAssert.assertThat(shoppingCart.isEmpty(), is (false));
        MatcherAssert.assertThat(shoppingCart.getQuantity(), is (8));
        // Total amount now should be 8*39.92 =
        MatcherAssert.assertThat(shoppingCart.getTotalCost(),
                is (equalTo( new BigDecimal("359.91").setScale(2, RoundingMode.HALF_UP))));

    }

    @Test
    public void shouldBeAbleToAddAxeDeoProduct(){
        shoppingCart.addProduct(new AxeDeo());
        MatcherAssert.assertThat(shoppingCart.getQuantity(), is(1));
        // The value now is with taxes
        MatcherAssert.assertThat(shoppingCart.getTotalCost(), is(equalTo (new BigDecimal("112.49"))));

    }


    @Test
    public void shouldBeAbleToCalculateTotalWithTaxesApplied(){

        shoppingCart.addProduct(new AxeDeo());
        shoppingCart.addProduct(new AxeDeo());

        shoppingCart.addProduct(new DoveSoap());
        shoppingCart.addProduct(new DoveSoap());

        MatcherAssert.assertThat(shoppingCart.getTotalCost(), is(equalTo((new BigDecimal("314.96")))));

    }

    @Test
    public void shouldBeAbleToCalculateTotalTaxesApplied(){

        shoppingCart.addProduct(new AxeDeo());
        shoppingCart.addProduct(new AxeDeo());

        shoppingCart.addProduct(new DoveSoap());
        shoppingCart.addProduct(new DoveSoap());

        MatcherAssert.assertThat(shoppingCart.getAppliedTaxOfSales(), is( equalTo(new BigDecimal("35.00"))));

    }






}
