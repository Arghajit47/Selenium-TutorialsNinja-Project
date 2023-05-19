package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By newCustomerContinueButton = By.xpath("//a[contains(text(),'Continue')]");
    By loginButton = By.cssSelector("form#form-login>button");
    By email = By.id("input-email");
    By password = By.id("input-password");
    By forgottenPassword = By.xpath("//input[@name='password']/following-sibling::a[1]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateLoginPage() {
        driver.findElement(newCustomerContinueButton).isDisplayed();
        driver.findElement(email).isDisplayed();
        driver.findElement(password).isDisplayed();
        driver.findElement(loginButton).isDisplayed();
        driver.findElement(forgottenPassword).isDisplayed();
    }
    public void loginUser(String emailId, String Password) {
        driver.findElement(email).sendKeys(emailId);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(loginButton).click();
    }
}
