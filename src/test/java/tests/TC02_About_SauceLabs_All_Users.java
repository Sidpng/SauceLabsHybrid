package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Standard_User_All_Scenarios.Standard_user_login;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class TC02_About_SauceLabs_All_Users extends BaseClass {

    ReadConfig readConfig = new ReadConfig();
    @Test(priority = 7, enabled = false)
    public void aboutSauceLabs_standard_user() throws IOException, InterruptedException {
        Standard_user_login standardUserLogin = new Standard_user_login();
        standardUserLogin.standard_user_login();
        Thread.sleep(2000);
        driver.findElement(By.xpath(readConfig.getProperty("additional_menu_icon"))).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(readConfig.getProperty("aboutUs_button"))));
        element.click();
        List<WebElement> elements = driver.findElements(By.xpath("//a[@href='/request-demo']/button[1]"));
        elements.get(2).click();
        Assert.assertEquals(driver.getTitle(),"Request a Sauce Labs Demo");
    }
}
