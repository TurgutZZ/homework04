package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Driver;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;


    @BeforeTest
    public void setup(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(500));

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


    public void sendKeys(By locator, CharSequence...text){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);

    }


    public void scrollToElement(WebElement element){
        new Actions(driver).scrollToElement(element).perform();
    }


    public void clickToElement(WebElement element){
        scrollToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickToLocator(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
       clickToElement(element);
    }

    public void clickByAction(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        new Actions(driver).scrollToElement(element).moveToElement(element).click().perform();
    }

    public void clickJs(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void clickJs(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }






}
