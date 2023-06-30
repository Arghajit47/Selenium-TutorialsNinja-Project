package org.TutorialsNinjaProject.com;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AccountsPageTest {
    WebDriver driver = new ChromeDriver();
    HomePage objHomePage = new HomePage(driver);
    LoginPage objLoginPage = new LoginPage(driver);
    Pages.AccountsPage objAccountsPage = new Pages.AccountsPage(driver);

    Properties prop = new Properties();
    FileInputStream fis;
    {
        try {
            String currentDirectory = System.getProperty("user.dir");
            System.out.println("Current Directory: " + currentDirectory);
            fis = new FileInputStream(currentDirectory + "/src/test/java/org/TutorialsNinjaProject/com/Data.properties");
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
        objHomePage.clickOnMyAccount();
        objHomePage.clickOnLoginOption();
        String email = prop.getProperty("EmailId");
        String password = prop.getProperty("Password");
        objLoginPage.loginUser(email, password);
    }

    @Test(priority = 1)
    public void verifyAccountsPage() {
        objAccountsPage.validateMyAccountPage();
        objHomePage.clickOnMyAccount();
        objLoginPage.seesMyAccountOptionAfterLogin();

    }


    @AfterSuite
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
