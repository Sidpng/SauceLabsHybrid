package tests.Standard_User_All_Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import tests.BaseClass;

import java.io.IOException;
import java.util.logging.Level;

public class Standard_user_sortProductsFilter extends BaseClass {

    @Test(priority = 9)
    public void standard_user_order_product() throws IOException {

        Standard_user_login standard_user_login = new Standard_user_login();
        try {

            LOGGER.log(Level.INFO, "Test Case: standard_user_order_product");
            standard_user_login.standard_user_login();

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
        LOGGER.log(Level.INFO, "Selecting filter option for standard user");
        Select select = new Select(driver.findElement(By.xpath(readConfig.getProperty("filterProductsDropdown"))));
        select.selectByIndex(1);
    }
}
