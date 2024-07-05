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

public class Standard_user_orderProduct extends BaseClass {

    @Test(priority = 7)
    public void standard_user_order_product() throws IOException {

        Standard_user_login standard_user_login = new Standard_user_login();
        standard_user_login.standard_user_login();
        global.clickElementByXPath(readConfig.getProperty("product_backpack"));
        global.clickElementByXPath(readConfig.getProperty("addToCart_button"));
        global.clickElementByXPath(readConfig.getProperty("cart_button"));
        global.clickElementByXPath(readConfig.getProperty("checkout_button"));
        global.sendKeysToElementByXPath(readConfig.getProperty("checkout_firstName"),"Siddhant",
                10);
        global.sendKeysToElementByXPath(readConfig.getProperty("checkout_lastName"),"U",
                10);
        global.sendKeysToElementByXPath(readConfig.getProperty("zip"),"281924",
                10);
        global.clickElementByXPath(readConfig.getProperty("second_checkout_button"));
        global.clickElementByXPath(readConfig.getProperty("finish_button"));

        File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date d1 = new Date();
        String FileName1 = d1.toString().replace(":", "_")
                .replace(" ", "_") + "StandardUser_ProductCheckout.png";
        File destinationFile1 = new File(readConfig.getProperty("standardUser_testEvidences") + FileName1);
        FileHandler.copy(screenshot1, destinationFile1);
    }
}
