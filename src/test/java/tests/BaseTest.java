package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;


    @BeforeTest
    public void setup() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


    public void sendKeys(By locator, CharSequence... text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);

    }


    public void scrollToElement(WebElement element) {
        new Actions(driver).scrollToElement(element).perform();
    }


    public void clickToElement(WebElement element) {
        scrollToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickToLocator(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        clickToElement(element);
    }

    public void clickByAction(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        new Actions(driver).scrollToElement(element).moveToElement(element).click().perform();
    }

    public void clickJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void clickJs(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }


    public static void takeScreenShot(String fileName) {
        fileName += "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String filePath = "test-output/screenshots/" + fileName + ".png";
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeScreenShot(WebElement element, String name) {

        File source = element.getScreenshotAs(OutputType.FILE);
        String fileName = name + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".png";
        File target = new File("Screenshots/" + fileName);
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}

    /*
    public static void takeScreenshot(WebDriver driver, String fileName) {
        // WebDriver'ı TakesScreenshot türüne dönüştür
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Ekran görüntüsünü al ve bir dosyaya kaydet
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(fileName);

        try {
            // Dosyayı belirtilen konuma kopyala
            FileUtils.copyFile(screenshotFile, destinationFile);
            System.out.println("Ekran görüntüsü başarıyla alındı: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Ekran görüntüsü alınamadı: " + e.getMessage());
        }
    }

     */




