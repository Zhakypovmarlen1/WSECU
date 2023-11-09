package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignInPage {

    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "username")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.=' Sign In ']")
    public WebElement signInButton;

    @FindBy(xpath = "//ng-message")
    public WebElement passwordMissingMessage;

    @FindBy(xpath = "//div[@class='ng-binding ng-scope']")
    public WebElement incorrectUsernameMessage;
}
