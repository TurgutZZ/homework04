package tests;

import org.testng.annotations.Test;
import utils.Driver;

public class TestRegister extends BaseTest {

    Locators locators;

    @Test
    public void performTest() {
        Driver.getDriver().get("http://automationexercise.com");

        locators = new Locators();

        locators.eLogin.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ekran görüntüsü al
        takeScreenshot(driver, "search_results.png");

        // Tarayıcıyı kapat
        driver.quit();
    }
}
