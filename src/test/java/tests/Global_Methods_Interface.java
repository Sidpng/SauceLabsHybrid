package tests;

import org.openqa.selenium.WebElement;

public interface Global_Methods_Interface {

    void sendKeysToElementByXPath(String xpath, String keys, int timeoutInSeconds);

    void clickElementByID(String xpath);

    WebElement waitForElementByXPath(String xpath, int timeoutInSeconds);
    void clickElementByXPath(String xpath);

}
