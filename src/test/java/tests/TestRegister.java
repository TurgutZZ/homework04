package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.Driver;
//import static tests.Locators.*;

public class TestRegister extends BaseTest {

    Locators locators;




    @Test
    public void performTest() {

        locators = new Locators();

        Faker faker = new Faker();


        Driver.getDriver().get("http://automationexercise.com");

        // 3.     Verify that home page is visible successfully
        try {
            wait.until(ExpectedConditions.visibilityOf(locators.eLogo));
            test.info("Basarili bir sekilde sayfa acildi!");
        }catch (Exception e) {
            test.warning("Sayfa acilmadi!");
        }

        // 4.     Click on 'Signup / Login' button
        locators.eLogin.click();

        // 5.     Verify 'New User Signup!' is visible
        try {
            wait.until(ExpectedConditions.visibilityOf(locators.eSingUpVerify));
            test.info("Basarili bir sekilde sayfa login acildi!");
        }catch (Exception e) {
            test.warning("Login Sayfasi acilmadi!");
        }

        // 6.     Enter name and email address
        locators.eName.sendKeys(faker.name().fullName());
        locators.eEmail.sendKeys(faker.internet().emailAddress());


        // 7.     Click 'Signup' button
        try {
            clickToElement(locators.eSignUp);
            test.info("Basariyla login olundu");
        }catch (Exception e) {
            test.warning("SignUp Tiklanamadi");
        }


        // 8.     Verify that 'ENTER ACCOUNT INFORMATION' is visible
        try {
            wait.until(ExpectedConditions.visibilityOf(locators.eEnterAccountVisible));
            test.info("ENTER ACCOUNT INFORMATION is visible!");
        }catch (Exception e) {
            test.warning("ENTER ACCOUNT INFORMATION is not visible!!");
        }

        //  9.  Fill details: Title, Name, Email, Password, Date of birth
        //clickByAction(getGender("Mr."));
        clickByAction(locators.getGender("Mr."));

        locators.ePassword.sendKeys(faker.internet().password());
        new Select(locators.eSelectDays).selectByIndex(15);
        new Select(locators.eSelectMonths).selectByIndex(4);
        new Select(locators.eSelectYears).selectByValue("1993");

        //     10. Select checkbox 'Sign up for our newsletter!'
        //     11. Select checkbox 'Receive special offers from our partners!'
        /*
        for (WebElement each : locators.eCheckBoxes ) {
            clickToElement(each);
        }
         */
        selectHobby("Sign up for our newsletter!", "Receive special offers from our partners!");

        //     12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        sendKeys(locators.lFirstName, "alp");
        sendKeys(locators.lLastName, "kalp");
        sendKeys(locators.lCompany, "Kalbi Kirik Gmbh");
        sendKeys(locators.lAddress1, "Kale Caddesi");
        sendKeys(locators.lAddress2, "Kirikkale");

        new Select(locators.eSelectCountry).selectByIndex(2);

        sendKeys(locators.lState, "Kirgizistan");
        sendKeys(locators.lCity, "Konya");
        sendKeys(locators.lZipcode, "33332");
        sendKeys(locators.lMobileNumber,"0178444444");

//        13. Click 'Create Account button'
        clickJs(locators.lCreateAccount);

//       14. Verify that 'ACCOUNT CREATED!' is visible

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locators.lAccountCreated));
            test.info("create edildi");
        } catch (Exception e){
            test.fail("Create edilemedi");
            takeScreenShot("SC_CreateEdilemedi");
        }


//        15. Click 'Continue' button

        clickJs(locators.lContinue);

//        16. Verify that 'Logged in as username' is visible

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locators.lLoggedUsername));
            test.info("Logged in as username' is visible");
        } catch (Exception e){
            test.fail("Logged in as username' is invisible");
            takeScreenShot("SC_LoggedUsername");
        }


        //     17. Click 'Delete Account' button
        clickJs(locators.lDeleteAccount);

        //     18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(locators.eAccountDeletedText));
            test.info("Deleted Text is Visible");
        }catch (Exception e) {
            test.fail("Deleted Text is not Visible");
            takeScreenShot("SC_DeletedText");
        }


        try {
            clickJs(locators.lContinueLast);
            test.pass("Test Passed");
        }catch (Exception e) {
            test.fail("Test Fail");
            takeScreenShot("SC_NotContinue");
        }



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
