package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OrderItemPage {
    WebDriver driver;
    By cartButtonInHomePage = By.id("cart");
    By viewCartButton = By.xpath("//p[@class='text-right']//a[1]");
    By checkoutButton = By.xpath("(//p[@class='text-right']//a)[2]");
    By continueButtonInBillingDetails = By.id("button-payment-address");
    By continueButtonInDeliveryDetails = By.id("button-shipping-address");
    By continueButtonInDeliveryMethod = By.id("button-shipping-method");
    By continueButtonInPaymentMethod = By.id("button-payment-method");
    By addCommentsForOrder = By.cssSelector("textarea[name='comment']");
    By termsAndConditionsCheckbox = By.cssSelector("input[name='agree']");
    By confirmButton = By.id("button-confirm");
    By orderConfirmedText = By.cssSelector("div#content>h1");
    By getBackToHomePage = By.xpath("//a[@class='btn btn-primary']");
    public OrderItemPage(WebDriver driver) {
        this.driver = driver;
    }
    public void seesAndClickOnCartButton() {
        driver.findElement(cartButtonInHomePage).isDisplayed();
        driver.findElement(cartButtonInHomePage).click();;
    }
    public void seesProductInCart() {
        driver.findElement(viewCartButton).isDisplayed();
        driver.findElement(checkoutButton).isDisplayed();

    }
    public void goToCheckOut() {
        driver.findElement(checkoutButton).click();
    }
    public void confirmOrder() {
        driver.findElement(continueButtonInBillingDetails).click();
        driver.findElement(continueButtonInDeliveryDetails).click();
        driver.findElement(addCommentsForOrder).sendKeys("Ok to pay the shipping charges for testing");
        driver.findElement(continueButtonInDeliveryMethod).click();
        driver.findElement(addCommentsForOrder).sendKeys("Ok to select CashOnDelivery for testing");
        driver.findElement(termsAndConditionsCheckbox).click();
        driver.findElement(continueButtonInPaymentMethod).click();
        driver.findElement(confirmButton).click();
    }
    public void seesOrderConfirmedSuccessfully() {
        if (!driver.findElement(orderConfirmedText).getText().equals("Your order has been placed!")) {
            System.out.println("Order Confirmed");;
            driver.findElement(getBackToHomePage).click();
        } else {
            System.out.println("Order not done yet!");
        }


    }
}
