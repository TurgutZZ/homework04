package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            switch (browser.toLowerCase().trim()) {
                case "edge":
                    driver.set(new EdgeDriver());
                    break;
                case "firefox":
                    driver.set(new FirefoxDriver());
                    break;
                default:
                    driver.set(new ChromeDriver());
            }
        }
        return driver.get();
    }

    public static WebDriver getDriver() {
        return getDriver("chrome");

    }


    public static void quit() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.set(null);
        }
    }


}
