package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.HomePage;

public class AuthTest extends BaseTest {

 
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                {"Manasa", "Password123"},
                {"invalidUser", "wrongPass"}
        };
    }

    @Test(dataProvider = "loginData")
    public void verifyLogin(String username, String password) {

        HomePage home = new HomePage(getDriver());
        AuthPage auth = new AuthPage(getDriver());

        home.clickLogin();
        auth.login(username, password);

        String alert = auth.getAlertTextIfPresent();

        if (alert != null) {
            System.out.println("Login Alert: " + alert);
            auth.acceptAlertIfPresent();


            Assert.assertTrue(alert.toLowerCase().contains("wrong") 
                    || alert.toLowerCase().contains("user"));
        } else {

            home.waitForUserLogin();
            Assert.assertTrue(home.getLoggedInUser().contains(username));

            home.clickLogout();
        }
    }
}