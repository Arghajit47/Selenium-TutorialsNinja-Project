package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class AddItemsPage {
    WebDriver driver;

    By addToCartButton = By.xpath("(//span[text()='Add to Cart'])");
    By addToWishListButton = By.cssSelector("button[data-original-title=\"Add to Wish List\"]");
    By compareButton = By.cssSelector("button[data-original-title=\"Compare this Product\"]");
    By sortByOption = By.id("input-sort");
    By dataElementShowButton = By.id("input-limit");
    By phoneAndPDAsOption = By.linkText("Phones & PDAs");
    By seesAllPhones = By.cssSelector("div#content > div > div > div[class=\"product-thumb\"]");
    By addHtcTouchHDToCart = By.xpath("(//span[text()='Add to Cart'])[1]");
    By successMessage = By.xpath("//div[contains(@class,'alert alert-success')]");



    public AddItemsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void AddToCart() {
        driver.findElement(addHtcTouchHDToCart).click();
    }
    public void seesAndClickOnPhoneAndPDAOption() {
        driver.findElement(phoneAndPDAsOption).getAttribute("href").equals("https://tutorialsninja.com/demo/index.php?route=product/category&path=24");
        driver.findElement(phoneAndPDAsOption).click();
    }
    public void seesPhoneAndPDAsPage() {
        for (int i = 0; i < 3; i++) {
            driver.findElements(seesAllPhones).get(i).isDisplayed();
            driver.findElements(addToCartButton).get(i).isDisplayed();
            driver.findElements(addToWishListButton).get(i).isDisplayed();
            driver.findElements(compareButton).get(i).isDisplayed();
        }
        driver.findElement(sortByOption).isDisplayed();
        driver.findElement(dataElementShowButton).isDisplayed();
    }
    public void verifyProductAddedToCartSuccessfully() {
        driver.findElement(successMessage).isDisplayed();
    }
}
