package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAccountPage {
    WebDriver driver;
    By topBarHomeOption = By.xpath("(//li[@class='breadcrumb-item'])[1]");
    By topBarAccountOption = By.xpath("(//li[@class='breadcrumb-item'])[2]");
    By getTopBarRegisterOption = By.xpath("(//li[@class='breadcrumb-item'])[3]");
    By loginPageText = By.xpath("//a[contains(text(),'login page')]");
    By firstNamePlaceholder = By.id("input-firstname");
    By lastNamePlaceholder = By.id("input-lastname");
    By emailPlaceholder = By.id("input-email");
    By passwordPlaceholder = By.id("input-password");
    By newsletterYes = By.id("input-newsletter-yes");
    By newsletterNo = By.id("input-newsletter-no");
    By privacyPolicyCheckBox = By.name("agree");
    By continueButton = By.cssSelector("button[type='submit']");
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
        driver.findElement(passwordPlaceholder).isDisplayed();
        driver.findElement(newsletterYes).isDisplayed();
        driver.findElement(newsletterNo).isSelected();
        driver.findElement(privacyPolicyCheckBox).isDisplayed();
        driver.findElement(continueButton).isDisplayed();
        for(int i =0; i < 13; i++) {
           driver.findElements(columnRightOptions).get(i).isDisplayed();
        }
    }
    public void registerUser(String firstName, String lastName, String email, String password) {
        driver.findElement(firstNamePlaceholder).sendKeys(firstName);
        driver.findElement(lastNamePlaceholder).sendKeys(lastName);
        driver.findElement(emailPlaceholder).sendKeys(email);
        driver.findElement(newsletterYes).click();
        driver.findElement(newsletterYes).isSelected();
        driver.findElement(privacyPolicyCheckBox).click();
        driver.findElement(privacyPolicyCheckBox).isSelected();
        driver.findElement(continueButton).click();
    }
}
