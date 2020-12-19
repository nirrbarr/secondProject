package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverManager;

public class BasePage {
    public void clickElement(By locator) throws Exception {
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) throws Exception {
        getWebElement(locator).sendKeys(text);
    }

    private WebElement getWebElement(By locator) throws Exception {
        return DriverManager.getDriverInstance().findElement(locator);
    }
}
