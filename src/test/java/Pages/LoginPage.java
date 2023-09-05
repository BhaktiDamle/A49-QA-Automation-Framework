package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;


    public LoginPage provideEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
        return this;

    }

    public LoginPage providePassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;

    }

    public LoginPage clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        return this;

    }
}


