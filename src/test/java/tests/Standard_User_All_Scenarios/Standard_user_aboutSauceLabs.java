package tests.Standard_User_All_Scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseClass;

import java.io.IOException;
import java.util.logging.Level;

public class Standard_user_aboutSauceLabs extends BaseClass {

    @Test(priority = 7)
    public void standard_user_order_product() throws IOException {

        Standard_user_login standard_user_login = new Standard_user_login();
        try {

            LOGGER.log(Level.INFO, "Test Case: standard_user_order_product");
            standard_user_login.standard_user_login();

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
        LOGGER.log(Level.INFO, "Selecting additional option for standard user");
        global.waitForElementByXPath(readConfig.getProperty("additional_menu_icon"), 10);
        global.clickElementByXPath(readConfig.getProperty("additional_menu_icon"));
        LOGGER.log(Level.INFO, "Selecting additional option for standard user");
        global.clickElementByXPath(readConfig.getProperty("aboutUs_button"));
        Assert.assertEquals(driver.getTitle(), "Sauce Labs: Cross Browser Testing," +
                " Selenium Testing & Mobile Testing");
    }
}
