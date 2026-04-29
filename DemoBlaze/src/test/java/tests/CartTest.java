package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class CartTest extends BaseTest {

    @Test
    public void verifyAddProductToCart() {

        HomePage home = new HomePage(getDriver());
        ProductPage product = new ProductPage(getDriver());
        CartPage cart = new CartPage(getDriver());

        home.clickPhones();

        product.selectFirstProduct();
        product.waitForProductPage();

        product.addToCart();
        product.acceptAlertIfPresent();

        cart.openCart();
        cart.waitForCartPage();

        Assert.assertTrue(cart.isProductPresent(), "Product not added to cart");
    }

    @Test
    public void verifyDeleteProductFromCart() {

        HomePage home = new HomePage(getDriver());
        ProductPage product = new ProductPage(getDriver());
        CartPage cart = new CartPage(getDriver());

        home.clickPhones();
        product.selectFirstProduct();
        product.waitForProductPage();

        product.addToCart();
        product.acceptAlertIfPresent();

        cart.openCart();
        cart.waitForCartPage();

        cart.deleteProduct();

        
        cart.waitForCartUpdate();

        Assert.assertFalse(cart.isProductPresent(), "Product still present after deletion");
    }
}