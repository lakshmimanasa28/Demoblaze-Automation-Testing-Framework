package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.HomePage;
import utils.ConfigReader;

public class FormValidationTest extends BaseTest {

    ConfigReader config = new ConfigReader();

  
    @Test
    public void verifyLoginWithEmptyUsername() {

        HomePage home = new HomePage(getDriver());
        AuthPage auth = new AuthPage(getDriver());

        home.clickLogin();
        auth.login("", "1234");

        String alert = auth.getAlertTextIfPresent();

        Assert.assertNotNull(alert, "Alert not shown");
        System.out.println("Login Alert: " + alert);

        Assert.assertTrue(
                alert.toLowerCase().contains("please"),
                "Expected validation alert but got: " + alert
        );

        auth.acceptAlertIfPresent();
    }

  
    @Test
    public void verifySignupWithExistingUser() {

        HomePage home = new HomePage(getDriver());
        AuthPage auth = new AuthPage(getDriver());

        home.clickSignUp();
        auth.signup(config.getUsername(), config.getPassword());

        String alert = auth.getAlertTextIfPresent();

        Assert.assertNotNull(alert, "Alert not shown");
        System.out.println("Signup Alert: " + alert);

        Assert.assertTrue(
                alert.toLowerCase().contains("already") ||
                alert.toLowerCase().contains("successful"),
                "Unexpected alert: " + alert
        );

        auth.acceptAlertIfPresent();
    }


    @Test
    public void verifySignupFieldsRetainValues() {

        HomePage home = new HomePage(getDriver());
        AuthPage auth = new AuthPage(getDriver());

        home.clickSignUp();

        String username = "testUser";
        String password = "1234";

        auth.enterSignupUsername(username);
        auth.enterSignupPassword(password);

        Assert.assertEquals(auth.getSignupUsernameValue(), username);
        Assert.assertEquals(auth.getSignupPasswordValue(), password);
    }
}