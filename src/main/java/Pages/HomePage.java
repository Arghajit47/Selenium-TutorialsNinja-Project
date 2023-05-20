package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By homePageLogo = By.id("logo");
    By searchBar = By.id("search");
    By cartButton = By.id("cart");
    By currencyOption = By.id("form-currency");
    By contactNumber = By.cssSelector("ul > li > span");
    By myAccountOption = By.cssSelector("a[title='My Account']");
    By wishList = By.id("wishlist-total");
    By shoppingCart = By.cssSelector("a[title='Shopping Cart']");
    By checkout = By.cssSelector("a[title='Checkout']");
    By navbarManuOptions = By.cssSelector("#menu > div > ul > li");
    By featuredElements = By.cssSelector("div#content>div:nth-of-type(2)>div>div");
    By banner1 = By.cssSelector("img[alt=\"iPhone 6\"]");
    By banner2 = By.cssSelector("img[alt=\"MacBookAir\"]");
    By previousButton = By.className("swiper-button-prev");
    By nextButton = By.className("swiper-button-next");
    By registerOption = By.xpath("//a[contains(text(),'Register')]");
    By loginOption = By.xpath("//a[contains(text(),'Login')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateHomePage() {
        driver.getTitle().equals("Your Store");
        driver.findElement(currencyOption).isDisplayed();
        driver.findElement(homePageLogo).isDisplayed();
        driver.findElement(searchBar).isDisplayed();
        driver.findElement(cartButton).isDisplayed();
        driver.findElement(contactNumber).isDisplayed();
        driver.findElement(myAccountOption).isDisplayed();
        driver.findElement(wishList).isDisplayed();
        driver.findElement(shoppingCart).isDisplayed();
        driver.findElement(checkout).isDisplayed();
        for(int i = 0; i < 8; i++) {
            driver.findElements(navbarManuOptions).get(i).isDisplayed();
        }
        for(int i =0; i<4; i++) {
            driver.findElements(featuredElements).get(i).isDisplayed();
        }
        driver.findElement(banner1).isDisplayed();
        driver.findElement(banner2).isDisplayed();
        for(int i =0; i<2; i++) {
            driver.findElements(previousButton).get(i).isDisplayed();
            driver.findElements(nextButton).get(i).isDisplayed();
        }
    }
    public void clickOnMyAccount() {
        driver.findElement(myAccountOption).click();
    }
    public void seesMyAccountSubOptions() {
        driver.findElement(registerOption).isDisplayed();
        driver.findElement(loginOption).isDisplayed();
    }
    public void clickOnRegisterOption() {
        driver.findElement(registerOption).click();

    }
    public void clickOnLoginOption() {
        driver.findElement(loginOption).click();
    }

}
