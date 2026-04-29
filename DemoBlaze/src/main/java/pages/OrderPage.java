package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPage extends BasePage {

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    By placeOrderBtn = By.xpath("//button[text()='Place Order']");

    By nameField = By.id("name");
    By countryField = By.id("country");
    By cityField = By.id("city");
    By cardField = By.id("card");
    By monthField = By.id("month");
    By yearField = By.id("year");

    By purchaseBtn = By.xpath("//button[text()='Purchase']");

    By successMessage = By.xpath("//h2[text()='Thank you for your purchase!']");
    By okBtn = By.xpath("//button[text()='OK']");

    // Actions
    public void clickPlaceOrder() {
        try {
            WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(placeOrderBtn)
            );

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", btn);

        } catch (Exception e) {
            click(placeOrderBtn);
        }
    }

    public void fillOrderDetails(String name, String country, String city,
                                 String card, String month, String year) {

        type(nameField, name);
        type(countryField, country);
        type(cityField, city);
        type(cardField, card);
        type(monthField, month);
        type(yearField, year);
    }

    public void clickPurchase() {
        click(purchaseBtn);
    }

    public void confirmOrder() {
        click(okBtn);
    }

    public boolean isOrderSuccessful() {
        try {
            waitForVisibility(successMessage);
            return getText(successMessage)
                    .contains("Thank you for your purchase!");
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForOrderModal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
    }
}