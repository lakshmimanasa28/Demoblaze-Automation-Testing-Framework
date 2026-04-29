package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test
    public void verifyProductSelection() {

        HomePage home = new HomePage(getDriver());
        ProductPage product = new ProductPage(getDriver());

       
        home.clickPhones();


        product.selectFirstProduct();


        product.waitForProductPage();


        String productName = product.getProductName();
        String productPrice = product.getProductPrice();

        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + productPrice);

    
        Assert.assertNotNull(productName, "Product name is null");
        Assert.assertTrue(productName.length() > 0, "Product name is empty");

        Assert.assertNotNull(productPrice, "Product price is null");
        Assert.assertTrue(productPrice.contains("$"), "Price format incorrect");
    }
}