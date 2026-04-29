package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class OrderTest extends BaseTest {

    @Test
    public void verifySuccessfulOrderPlacement() {

        HomePage home = new HomePage(getDriver());
        ProductPage product = new ProductPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        OrderPage order = new OrderPage(getDriver());

        home.clickPhones();

        product.selectFirstProduct();
        product.waitForProductPage();

        product.addToCart();
        product.acceptAlertIfPresent();

        cart.openCart();
        cart.waitForCartPage();

        order.clickPlaceOrder();
        order.waitForOrderModal();

        order.fillOrderDetails(
                "Manasa",
                "India",
                "Guntur",
                "123456",
                "05",
                "2026"
        );

        order.clickPurchase();

        Assert.assertTrue(order.isOrderSuccessful(), "Order not successful");

        order.confirmOrder();
    }

    @Test
    public void verifyOrderWithEmptyFields() {

        HomePage home = new HomePage(getDriver());
        ProductPage product = new ProductPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        OrderPage order = new OrderPage(getDriver());

        home.clickPhones();

        product.selectFirstProduct();
        product.waitForProductPage();

        product.addToCart();
        product.acceptAlertIfPresent();

        cart.openCart();
        cart.waitForCartPage();

        order.clickPlaceOrder();
        order.waitForOrderModal();

        order.clickPurchase();

        Assert.assertFalse(order.isOrderSuccessful(), "Order should fail with empty fields");
    }
}