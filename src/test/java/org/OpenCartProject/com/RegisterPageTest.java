package org.OpenCartProject.com;

import Pages.HomePage;
import Pages.RegisterAccountPage;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RegisterPageTest {
    WebDriver driver = new ChromeDriver();
    HomePage objHomePage = new HomePage(driver);
    RegisterAccountPage objRegisterPage = new RegisterAccountPage(driver);
    Properties prop = new Properties();
    FileInputStream fis;
    {
        try {
            fis = new FileInputStream("/home/arghas/IdeaProjects/Selenium-OpenCart-Project/src/test/java/org/OpenCartProject/com/Data.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeTest
    public void setUp() throws Exception {
        driver. manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        prop.load(fis);
        String url = prop.getProperty("Url");
        driver.get(url);
    }

    @Test (priority = 1)
    public void verifyRegisterPage() {
        objHomePage.clickOnMyAccount();
        objHomePage.clickOnRegisterOption();
        objRegisterPage.validateRegisterPage();

    }
    @Test (priority = 2)
    public void createAccount() throws Exception {
        prop.load(fis);
        objHomePage.clickOnMyAccount();
        objHomePage.clickOnRegisterOption();
        String firstName = prop.getProperty("First_Name");
        String lastName = prop.getProperty("Last_Name");
        String email = prop.getProperty("EmailId");
        String password = prop.getProperty("Password");
        String phoneNumber = prop.getProperty("PhoneNumber");
        objRegisterPage.registerUser(firstName, lastName, email, password, phoneNumber);
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
