package tests.Locked_Out_User_All_Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Locked_user_login extends BaseClass {

    @Test(priority = 3, groups = {"Login_tests"})
    public void locked_out_user_login() throws IOException {

        driver.navigate().refresh();
        global.sendKeysToElementByXPath(readConfig.getProperty("username_input_field"),
                readConfig.getProperty("lockedOut_username"),10);
        global.sendKeysToElementByXPath(readConfig.getProperty("password_input_field"),
                readConfig.getProperty("password_for_all"),10);
        global.clickElementByXPath(readConfig.getProperty("login_button"));
        String url = driver.getCurrentUrl();

        /*
         * Capturing UI for test evidence
         * Naming convention to include dynamic time stamp
         */

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        String FileName = d.toString().replace(":", "_")
                .replace(" ", "_") + "LockedOutUser.png";
        File destinationFile = new File(readConfig.getProperty("lockedUser_testEvidences") + FileName);
        FileHandler.copy(screenshot, destinationFile);

        //Verifying whether the landed page is correct after login

        Assert.assertEquals(url, readConfig.getProperty("baseurl"));
        List<WebElement> ele = driver.findElements(By.xpath(readConfig.getProperty("locked_out_error_button")));
        Assert.assertTrue(ele.size() > 0);

        /*
         * Capturing UI for test evidence
         * Naming convention to include dynamic time stamp
         */

        File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d1 = new Date();
        String FileName1 = d1.toString().replace(":", "_")
                .replace(" ", "_") + "LockedOutUser.png";
        File destinationFile1 = new File(readConfig.getProperty("lockedUser_testEvidences") + FileName1);
        FileHandler.copy(screenshot1, destinationFile1);

    }

}
