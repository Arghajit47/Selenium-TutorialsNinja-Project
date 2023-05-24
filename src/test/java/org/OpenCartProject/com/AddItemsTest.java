package org.OpenCartProject.com;

import Pages.AddItemsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AddItemsTest {
    WebDriver driver = new ChromeDriver();
    HomePage objHomePage = new HomePage(driver);
    LoginPage objLoginPage = new LoginPage(driver);
    AddItemsPage objAddItemsPage = new AddItemsPage(driver);

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
    public void verifyDesktopsPage() {
        objAddItemsPage.seesDesktopsButton();
        objAddItemsPage.clickOnDesktopsButton();
        objAddItemsPage.seesDesktopsOption();
        objAddItemsPage.clickOnAllDesktops();
        objAddItemsPage.seesDesktopsPage();
    }
    @Test(priority = 2)
    public void addAppleCinemaToCart() {
        objAddItemsPage.clickOnProduct();
        objAddItemsPage.seesProductPageAndAddToCart();
    }


    @AfterSuite
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
