package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
    WebDriver driver;
    By myAccountAllOptions = By.cssSelector("div#content>ul>li>a");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By companyName = By.id("input-company");
    By address1 = By.id("input-address-1");
    By address2 = By.id("input-address-2");
    By city = By.id("input-city");
    By postCode = By.id("input-postcode");
    By country = By.id("input-country");
    By region = By.id("input-zone");
    By defaultAddressYes = By.xpath("(//input[@name='default'])[1]");
    By defaultAddressNo = By.xpath("(//input[@name='default'])[2]");
    By backButton = By.xpath("//a[contains(text(),'Back')]");
    By continueButton = By.cssSelector("input[type='submit']");
    By toastMessage = By.cssSelector("div.alert.alert-success.alert-dismissible");
    By editButton = By.cssSelector("a.btn.btn-info");
    By deleteButton = By.cssSelector("a.btn.btn-danger");
    By newAddressButton = By.cssSelector("a.btn.btn-primary");


    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnModifyAddress() {
        driver.findElements(myAccountAllOptions).get(2).isDisplayed();
        driver.findElements(myAccountAllOptions).get(2).click();
    }
    public void validateAddressBookScreen() {
        driver.findElement(backButton).isDisplayed();
        driver.findElement(newAddressButton).isDisplayed();
    }
    public void clickOnNewAddressButton() {
        driver.findElement(newAddressButton).click();
    }

    public void validateAddAddressPage() {
        driver.findElement(firstName).isDisplayed();
        driver.findElement(lastName).isDisplayed();
        driver.findElement(companyName).isDisplayed();
        driver.findElement(address1).isDisplayed();
        driver.findElement(address2).isDisplayed();
        driver.findElement(city).isDisplayed();
        driver.findElement(postCode).isDisplayed();
        driver.findElement(country).isDisplayed();
        driver.findElement(region).isDisplayed();
        driver.findElement(defaultAddressYes).isDisplayed();
        driver.findElement(defaultAddressNo).getAttribute("checked").equals("checked");
        driver.findElement(backButton).isDisplayed();
        driver.findElement(continueButton).getAttribute("value").equals("Continue");
    }
    public void addAddress(String First_Name, String Last_Name, String Company_Name, String Address1, String Address2, String cityName, String pinCode) {
        driver.findElement(firstName).sendKeys(First_Name);
        driver.findElement(lastName).sendKeys(Last_Name);
        driver.findElement(companyName).sendKeys(Company_Name);
        driver.findElement(address1).sendKeys(Address1);
        driver.findElement(address2).sendKeys(Address2);
        driver.findElement(city).sendKeys(cityName);
        driver.findElement(postCode).sendKeys(pinCode);
        WebElement countryElements = driver.findElement(country);
        Select country = new Select(countryElements);
        country.selectByValue("99");
        WebElement regionElements = driver.findElement(region);
        Select region = new Select(regionElements);
        region.selectByValue("1506");
        driver.findElement(defaultAddressYes).click();
        driver.findElement(defaultAddressYes).getAttribute("checked").equals("checked");
        driver.findElement(continueButton).click();
    }
    public void seesAddressAddedSuccessfully() {
        driver.findElement(toastMessage).getText().equals("Your address has been successfully added");
        driver.findElement(editButton).isDisplayed();
        driver.findElement(deleteButton).isDisplayed();
        driver.findElement(backButton).isDisplayed();
        driver.findElement(newAddressButton).isDisplayed();
    }
    public void seesAddressDeletedSuccessfully() {
        driver.findElement(toastMessage).getText().equals("Your address has been successfully deleted");
    }
    public void clickOnDeleteButton() {
        driver.findElement(deleteButton).click();
    }
}
