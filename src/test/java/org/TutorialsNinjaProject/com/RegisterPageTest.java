package org.TutorialsNinjaProject.com;

import Pages.HomePage;
import Pages.RegisterAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


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
        String firstName = prop.getProperty("First_Name");
        String lastName = prop.getProperty("Last_Name");
        String email = prop.getProperty("EmailId");
        String password = prop.getProperty("Password");
        String phoneNumber = prop.getProperty("PhoneNumber");
        objRegisterPage.registerUser(firstName, lastName, email, password, phoneNumber);
    }

    @AfterSuite
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
