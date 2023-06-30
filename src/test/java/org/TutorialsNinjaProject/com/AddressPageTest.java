package org.TutorialsNinjaProject.com;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AddressPageTest {
    WebDriver driver = new ChromeDriver();
    HomePage objHomePage = new HomePage(driver);
    LoginPage objLoginPage = new LoginPage(driver);
    AddressPage objAddAddressPage = new AddressPage(driver);

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
        String email = prop.getProperty("EmailId");
        String password = prop.getProperty("Password");
        driver.get(url);
        objHomePage.clickOnMyAccount();
        objHomePage.clickOnLoginOption();
        objLoginPage.loginUser(email, password);
    }
    @Test(priority = 1)
    public void verifyModifyAddressPage() {
        objAddAddressPage.clickOnModifyAddress();
        objAddAddressPage.validateAddressBookScreen();

    }

    @Test(priority = 2)
    public void verifyAddAddressPage() {
        objAddAddressPage.clickOnNewAddressButton();
        objAddAddressPage.validateAddAddressPage();

    }
    @Test(priority = 3)
    public void addAddress() throws Exception {
        prop.load(fis);
        String firstName = prop.getProperty("First_Name");
        String lastName = prop.getProperty("Last_Name");
        String companyName = prop.getProperty("companyName");
        String address1 = prop.getProperty("Address1");
        String address2 = prop.getProperty("Address2");
        String city = prop.getProperty("City");
        String postCode = prop.getProperty("Pin_Code");
        objAddAddressPage.addAddress(firstName, lastName, companyName, address1, address2, city, postCode);
        objAddAddressPage.seesAddressAddedSuccessfully();
    }
    @Test(priority = 4)
    public void deleteAddress() {
        objAddAddressPage.clickOnDeleteButton();
        objAddAddressPage.seesAddressDeletedSuccessfully();
    }


    @AfterSuite
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
