package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElements(addToCartButton).get(0).isDisplayed();
    }

}
