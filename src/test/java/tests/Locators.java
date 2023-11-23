package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class Locators {

    public Locators() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//img[@alt='Website for automation practice']")
    public WebElement eLogo;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement eSingUpVerify;

    @FindBy(xpath = "(//ul[@class='nav navbar-nav']//a)[4]")
    public WebElement eLogin;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement eName;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    public WebElement eEmail;

    @FindBy(xpath = "(//form[@method='POST']//button)[2]")
    public WebElement eSignUp;

    @FindBy(xpath = "//b[text()=\"Enter Account Information\"]")
    public WebElement eEnterAccountVisible;

    @FindBy(xpath = "//div[@class='radio-inline']//input")
    public List<WebElement> eRadioCenders;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement ePassword;

    @FindBy(xpath = "//select[@name='days']")
    public WebElement eSelectDays;

    @FindBy(xpath = "//select[@name='months']")
    public WebElement eSelectMonths;

    @FindBy(xpath = "//select[@name='years']")
    public WebElement eSelectYears;

    @FindBy(xpath = "//div[@class='checkbox']//input")
    public List<WebElement> eCheckBoxes;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement eSelectCountry;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement eAccountCreated;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    public WebElement eLoggedVisiable;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    public WebElement eAccountDeleted;

    @FindBy(xpath = "//button[text()='Create Account']")
    public WebElement eCreateAccount;


    By lFirstName = By.xpath("//input[@id='first_name']");
    By lLastName = By.xpath("//input[@id='last_name']");
    By lCompany = By.xpath("//input[@id='company']");
    By lAddress1 = By.xpath("//input[@id='address1']");
    By lAddress2 = By.xpath("//input[@id='address2']");

    By lState = By.xpath("//input[@id='state']");
    By lCity = By.xpath("//input[@id='city']");
    By lZipcode = By.xpath("//input[@id='zipcode']");
    By lMobileNumber = By.xpath("//input[@id='mobile_number']");

    By lCreateAccount = By.xpath("//button[text()='Create Account']");

    By lAccountCreated = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");

    By lContinue = By.xpath("//a[text()='Continue']");

    By lDeleteAccount = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");

    By lContinueLast = By.xpath(("//a[text()='Continue']"));


    public static By getGender(String gender) {
        return By.xpath("(//div[@class='radio-inline']//parent::div[contains(., '" + gender + "')])[2]");

    }

}