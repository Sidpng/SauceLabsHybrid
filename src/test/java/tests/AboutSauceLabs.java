package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class AboutSauceLabs extends BaseClass{

    @Test
    public void aboutSauceLabs() throws IOException {
        SauceLabsLogin_StandardUser user = new SauceLabsLogin_StandardUser();
        user.standard_user_login();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='about_sidebar_link']")));
        element.click();
    }
}
