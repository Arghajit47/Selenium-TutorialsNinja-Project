package org.TutorialsNinjaProject.com;

import Pages.AddItemsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrderItemPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class OrderItemTest {
    WebDriver driver = new ChromeDriver();
    HomePage objHomePage = new HomePage(driver);
    LoginPage objLoginPage = new LoginPage(driver);
    OrderItemPage objOrderItemPage = new OrderItemPage(driver);

    Properties prop = new Properties();
    FileInputStream fis;
    {
        try {
            fis = new FileInputStream("/home/arghas/IdeaProjects/Selenium-OpenCart-Project/src/test/java/org/OpenCartProject/com/Data.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeSuite
    public void setUp() throws Exception {
        driver. manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        prop.load(fis);
        String url = prop.getProperty("Url");
        String email = prop.getProperty("EmailId");
        String password = prop.getProperty("Password");
        driver.get(url);
        objHomePage.clickOnMyAccount();
        objHomePage.clickOnLoginOption();
        objLoginPage.loginUser(email, password);
    }
    @Test(priority = 1)
    public void verifyCart() {
       objOrderItemPage.seesAndClickOnCartButton();
       objOrderItemPage.seesProductInCart();
       objOrderItemPage.goToCheckOut();
        objOrderItemPage.confirmOrder();
        objOrderItemPage.seesOrderConfirmedSuccessfully();
    }



    @AfterSuite
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
