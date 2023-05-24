package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddItemsPage {
    WebDriver driver;

    By desktopsOption = By.cssSelector("nav[id=\"menu\"] > div > ul > li[class=\"dropdown\"]");
    By pcOnly = By.xpath("(//ul[@class='list-unstyled']//a)[1]");
    By macOnly = By.xpath("(//ul[@class='list-unstyled']//a)[2]");
    By seesAllDesktopsButton = By.xpath("(//a[@class='see-all'])[1]");
    By seesVariousDesktops = By.cssSelector("div#content > div > div > div[class=\"product-thumb\"]");
    By addToCartButton = By.xpath("(//span[text()='Add to Cart'])");
    By addToWishListButton = By.cssSelector("button[data-original-title=\"Add to Wish List\"]");
    By compareButton = By.cssSelector("button[data-original-title=\"Compare this Product\"]");
    By sortByOption = By.id("input-sort");
    By dataElementShowButton = By.id("input-limit");
    By radioButtons = By.cssSelector("input[name=\"option[218]\"]");
    By checkboxButtons = By.cssSelector("input[name=\"option[223][]\"]");
    By textPlaceholder = By.id("input-option208");
    By selectDropdown = By.id("input-option217");
    By textAreaPlaceholder = By.id("input-option209");
    By dateField = By.id("input-option219");
    By timeField = By.id("input-option221");
    By dateAndTimeField = By.id("input-option220");
    By quantityField = By.id("input-quantity");
    By addToCartButtonInProductPage = By.id("button-cart");



    public AddItemsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void seesDesktopsButton() {
        driver.findElements(desktopsOption).get(0).isDisplayed();

    }
    public void clickOnDesktopsButton() {
        driver.findElements(desktopsOption).get(0).click();
    }
    public void seesDesktopsOption() {
        driver.findElement(pcOnly).getAttribute("href").equals("https://tutorialsninja.com/demo/index.php?route=product/category&path=20_26");
        driver.findElement(macOnly).getAttribute("href").equals("https://tutorialsninja.com/demo/index.php?route=product/category&path=20_27");
        driver.findElement(seesAllDesktopsButton).getAttribute("href").equals("https://tutorialsninja.com/demo/index.php?route=product/category&path=20");
    }
    public void clickOnAllDesktops() {
        driver.findElement(seesAllDesktopsButton).click();

    }
    public void seesDesktopsPage() {
        for (int i = 0; i < 12; i++) {
            driver.findElements(seesVariousDesktops).get(i).isDisplayed();
            driver.findElements(addToCartButton).get(i).isDisplayed();
            driver.findElements(addToWishListButton).get(i).isDisplayed();
            driver.findElements(compareButton).get(i).isDisplayed();
        }
        driver.findElement(sortByOption).isDisplayed();
        driver.findElement(dataElementShowButton).isDisplayed();
    }
    public void clickOnProduct() {
        driver.findElements(addToCartButton).get(0).click();
    }
    public void seesProductPageAndAddToCart() {
        driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=product/product&product_id=42");
        driver.findElement(addToWishListButton).isDisplayed();
        driver.findElement(compareButton).isDisplayed();
        for (int i = 0; i < 2; i++) {
            driver.findElements(radioButtons).get(i).isDisplayed();
        }
        driver.findElements(radioButtons).get(0).isDisplayed();
        for (int i = 0; i < 3; i++) {
            driver.findElements(checkboxButtons).get(i).isDisplayed();
        }
        driver.findElements(checkboxButtons).get(2).isDisplayed();
        driver.findElement(textPlaceholder).sendKeys("Selenium WebDriver is doing everything");
        WebElement selectElements = driver.findElement(selectDropdown);
        Select select = new Select(selectElements);
        select.selectByValue("4");
        driver.findElement(textAreaPlaceholder).sendKeys("Input from keyboard into this textarea");
        driver.findElement(dateField).clear();
        driver.findElement(dateField).sendKeys("2023-05-24");
        driver.findElement(timeField).clear();
        driver.findElement(timeField).sendKeys("10:00");
        driver.findElement(dateAndTimeField).clear();
        driver.findElement(dateAndTimeField).sendKeys("2023-05-24 10:00");
        driver.findElement(quantityField).getAttribute("value").equals("2");
        driver.findElement(addToCartButtonInProductPage).click();
    }
}
