package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC02_About_SauceLabs_All_Users extends BaseClass {

    ReadConfig readConfig = new ReadConfig();
    @Test(priority = 7)
    public void aboutSauceLabs_standard_user() throws IOException {
        TC01_All_Login_Scenarios objLoginScenarios = new TC01_All_Login_Scenarios();
        objLoginScenarios.standard_user_login();
        driver.findElement(By.xpath(readConfig.getProperty("additional_menu_icon"))).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(readConfig.getProperty("aboutUs_button"))));
        element.click();

        //add page verification steps
    }
}
