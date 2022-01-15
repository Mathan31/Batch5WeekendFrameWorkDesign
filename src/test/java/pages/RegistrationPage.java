package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class RegistrationPage extends BaseClass{
	
	private By oFirstName = By.id("firstName");
	private By oMiddleName = By.id("middleName");
	private By oLastName = By.id("lastName");
	private By oUserName = By.id("username");
	private By oEmail = By.id("email");
	private By oPassword = By.id("password");
	private By oRegister = By.xpath("//button[text()='Register']");
	private By oTitle = By.id("title");
	private By oGender = By.id("sex");
	private By oUILogo = By.xpath("//a[@class='navbar-brand']");
	private By oLogin = By.xpath("//a[text()='Login']");
	private WebDriver driver;
	private SeleniumWrapper oWrap;
	
	public RegistrationPage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node = node;
		oWrap = new SeleniumWrapper(driver, node);
	}
	
	public boolean fieldValidation() {
		if(oWrap.verifyDisplayedwithReturn(driver.findElement(oUserName)) && oWrap.verifyDisplayedwithReturn(driver.findElement(oPassword))
				&& oWrap.verifyDisplayedwithReturn(driver.findElement(oEmail))&& oWrap.verifyDisplayedwithReturn(driver.findElement(oRegister))) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public LoginPage clickUILogo() {
		oWrap.click(driver.findElement(oUILogo));
		return new LoginPage(driver,node);
	}
	
	public LoginPage clickLogin() {
		oWrap.click(driver.findElement(oLogin));
		return new LoginPage(driver,node);
	}
	
	
	public RegistrationPage enterFirstName(String firstName) {
		oWrap.type(driver.findElement(oFirstName), firstName);
		return this;
	}
	
	public RegistrationPage selectTitle(String title) {
		oWrap.selectDropDownUsingVisibleText(driver.findElement(oTitle), title);
		return this;
	}
	
	public RegistrationPage enterMiddleName() {
		oWrap.type(driver.findElement(oMiddleName), "");
		return this;
	}
	
	public RegistrationPage enterLastName(String lastName) {
		oWrap.type(driver.findElement(oLastName),lastName);
		return this;
	}
	
	public RegistrationPage selectGender(String gender) {
		oWrap.selectDropDownUsingVisibleText(driver.findElement(oGender), gender);
		return this;
	}
	
	public RegistrationPage enterUserName(String userName) {
		oWrap.type(driver.findElement(oUserName),userName);
		return this;
	}
	
	public RegistrationPage enterEmail(String email) {
		oWrap.type(driver.findElement(oEmail),email);
		return this;
	}
	
	public RegistrationPage enterPassword(String password) {
		oWrap.type(driver.findElement(oPassword),password);
		return this;
	}
	
	public EmailVerificationPage clickRegisterLink() {
		oWrap.click(driver.findElement(oRegister));
		return new EmailVerificationPage(driver,node);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
