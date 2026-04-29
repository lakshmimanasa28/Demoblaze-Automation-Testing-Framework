package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

   
    By firstProduct = By.xpath("(//a[@class='hrefch'])[1]");
    By addToCartBtn = By.linkText("Add to cart");

    By productName = By.cssSelector(".name");
    By productPrice = By.cssSelector(".price-container");

   
    public void selectFirstProduct() {
        click(firstProduct);
    }

    public void addToCart() {
        click(addToCartBtn);
    }

    
    public String getProductName() {
        return getText(productName);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

 
    public void waitForProductPage() {
        waitForVisibility(productName);
    }
}