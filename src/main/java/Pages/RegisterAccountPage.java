package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAccountPage {
    WebDriver driver;
    By topBarHomeOption = By.xpath("//ul[@class='breadcrumb']//i[1]");
    By topBarAccountOption = By.xpath("(//ul[@class='breadcrumb']//a)[2]");
    By getTopBarRegisterOption = By.xpath("(//ul[@class='breadcrumb']//a)[3]");
    By loginPageText = By.xpath("//a[contains(text(),'login page')]");
    By firstNamePlaceholder = By.id("input-firstname");
    By lastNamePlaceholder = By.id("input-lastname");
    By emailPlaceholder = By.id("input-email");
    By telephoneNumber = By.id("input-telephone");
    By passwordPlaceholder = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By newsletterYes = By.xpath("(//input[@name='newsletter'])[1]");
    By newsletterNo = By.xpath("(//input[@name='newsletter'])[2]");
    By privacyPolicyCheckBox = By.name("agree");
    By continueButton = By.cssSelector("input[type='submit']");
    By columnRightOptions = By.cssSelector("aside#column-right>div>a");

    public RegisterAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateRegisterPage() {
        driver.findElement(topBarHomeOption).isDisplayed();
        driver.findElement(topBarAccountOption).isDisplayed();
        driver.findElement(getTopBarRegisterOption).isDisplayed();
        driver.findElement(loginPageText).getAttribute("href").equals("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
        driver.findElement(firstNamePlaceholder).isDisplayed();
        driver.findElement(lastNamePlaceholder).isDisplayed();
        driver.findElement(emailPlaceholder).isDisplayed();
        driver.findElement(telephoneNumber).isDisplayed();
        driver.findElement(passwordPlaceholder).isDisplayed();
        driver.findElement(confirmPassword).isDisplayed();
        driver.findElement(newsletterYes).isDisplayed();
        driver.findElement(newsletterNo).isSelected();
        driver.findElement(privacyPolicyCheckBox).isDisplayed();
        driver.findElement(continueButton).isDisplayed();
        for(int i =0; i < 13; i++) {
           driver.findElements(columnRightOptions).get(i).isDisplayed();
        }
    }
    public void registerUser(String firstName, String lastName, String email, String password, String phoneNumber) {
        driver.findElement(firstNamePlaceholder).sendKeys(firstName);
        driver.findElement(lastNamePlaceholder).sendKeys(lastName);
        driver.findElement(emailPlaceholder).sendKeys(email);
        driver.findElement(telephoneNumber).sendKeys(phoneNumber);
        driver.findElement(passwordPlaceholder).sendKeys(password);
        driver.findElement(confirmPassword).sendKeys(password);
        driver.findElement(newsletterYes).click();
        driver.findElement(newsletterYes).isSelected();
        driver.findElement(privacyPolicyCheckBox).click();
        driver.findElement(privacyPolicyCheckBox).isSelected();
        driver.findElement(continueButton).click();
    }
}
