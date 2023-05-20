package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage {
    WebDriver driver;
    By myAccountAllOptions = By.cssSelector("div#content>ul>li>a");
    By columnRightOptions = By.cssSelector("aside#column-right>div>a");

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyAccountsPageUrl(String url) {
        driver.getCurrentUrl().equals(url);
    }
    public void validateMyAccountPage() {

        for(int i = 0; i < 11; i++) {
            driver.findElements(myAccountAllOptions).get(i).isDisplayed();
        }
        for(int i =0; i < 13; i++) {
            driver.findElements(columnRightOptions).get(i).isDisplayed();
        }
    }

}
