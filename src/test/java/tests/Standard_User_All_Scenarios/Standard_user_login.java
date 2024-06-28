package tests.Standard_User_All_Scenarios;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Standard_user_login extends BaseClass {


    @Test(priority = 1, groups = {"Login_tests"})
    public void standard_user_login() throws IOException {

        global.sendKeysToElementByXPath(readConfig.getProperty("username_input_field"),
                readConfig.getProperty("standard_username"),10);
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
                .replace(" ", "_") + "StandardUser.png";
        File destinationFile = new File(readConfig.getProperty("standardUser_testEvidences") + FileName);
        FileHandler.copy(screenshot, destinationFile);

        //Verifying whether the landed page is correct after login

        Assert.assertEquals(url, readConfig.getProperty("afterLogin_url"));

        global.clickElementByXPath(readConfig.getProperty("additional_menu_icon"));
        global.waitForElementByXPath(readConfig.getProperty("logout_button"),10);
        global.clickElementByXPath(readConfig.getProperty("logout_button"));

        /*
         * Capturing UI for test evidence
         * Naming convention to include dynamic time stamp
         */

        File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d1 = new Date();
        String FileName1 = d1.toString().replace(":", "_")
                .replace(" ", "_") + "StandardUser.png";
        File destinationFile1 = new File(readConfig.getProperty("standardUser_testEvidences") + FileName1);
        FileHandler.copy(screenshot1, destinationFile1);
    }
}
