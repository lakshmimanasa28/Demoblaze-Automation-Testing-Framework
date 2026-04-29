package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By cartLink = By.id("cartur");
    By cartTable = By.id("tbodyid");
    By deleteBtn = By.linkText("Delete");


    public void openCart() {
        click(cartLink);
    }

    
    public void waitForCartPage() {
        waitForVisibility(cartTable);
    }

  
    public void deleteProduct() {
        click(deleteBtn);
    }

   
    public boolean isProductPresent() {
        return driver.findElements(By.linkText("Delete")).size() > 0;
    }


    public void waitForCartUpdate() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(deleteBtn));
    }
}