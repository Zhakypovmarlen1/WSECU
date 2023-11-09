package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.SignInPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class OnlineBanking {

    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();

@Test
    public void Test() {

    Driver.getDriver().get(Config.getValue("url"));

    homePage.signInButton.click();
    signInPage.usernameInput.sendKeys(Config.getValue("username"));
    signInPage.signInButton.click();
    ApplicationFlow.pause(500);

    String expectedMessage = "Please enter your password.";
    String expectedUrl = "https://digital.wsecu.org/banking/signin";

    Assert.assertTrue( signInPage.passwordMissingMessage.isDisplayed());
    Assert.assertEquals(expectedMessage,signInPage.passwordMissingMessage.getText());
    Assert.assertEquals(expectedUrl, Driver.getDriver().getCurrentUrl());
}

@Test
    public void Test1(){

    Driver.getDriver().get(Config.getValue("url"));

    homePage.signInButton.click();
    signInPage.usernameInput.sendKeys(Config.getValue("username"));
    signInPage.passwordInput.sendKeys(Config.getValue("password"));
    signInPage.signInButton.click();
    ApplicationFlow.pause(500);

    String expectedMessage = "Sorry, incorrect username.";

    Assert.assertTrue(signInPage.incorrectUsernameMessage.isDisplayed());
    Assert.assertEquals(expectedMessage, signInPage.incorrectUsernameMessage.getText());


}
}
