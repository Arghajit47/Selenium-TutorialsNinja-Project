package org.TutorialsNinjaProject.com;

import Pages.AccountsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    WebDriver driver = new ChromeDriver();
    HomePage objHomePage = new HomePage(driver);
    LoginPage objLoginPage = new LoginPage(driver);
    AccountsPage objAccountsPage = new AccountsPage(driver);

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
        driver.get(url);
    }

    @Test (priority = 1)
    public void verifyLoginPage() {
        objHomePage.clickOnMyAccount();
        objHomePage.clickOnLoginOption();
        objLoginPage.validateLoginPage();

    }
    @Test (priority = 2)
    public void logIntoAccount() throws Exception {
        prop.load(fis);
        String email = prop.getProperty("EmailId");
        String password = prop.getProperty("Password");
        objLoginPage.loginUser(email, password);
        String accountsPageUrl = prop.getProperty("AccountsPageUrl");
        objAccountsPage.verifyAccountsPageUrl(accountsPageUrl);
        objHomePage.clickOnMyAccount();
        objLoginPage.seesMyAccountOptionAfterLogin();
    }

    @AfterSuite
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
