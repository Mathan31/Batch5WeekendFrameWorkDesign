package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class LoginPage extends BaseClass{
	
	private By oUsername = By.id("username");
	private By oPassword = By.id("password");
	private By oSignIn = By.xpath("//button[text()='Sign In']");
	private By oRegister = By.xpath("//*[text()='Register For Account']");
	private WebDriver driver;
	private SeleniumWrapper oWrap;
	
	public LoginPage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node = node;
		oWrap = new SeleniumWrapper(driver, node);
	}
	
	public boolean verifyElement() {
		if(oWrap.verifyDisplayedwithReturn(driver.findElement(oUsername))&& oWrap.verifyDisplayedwithReturn(driver.findElement(oPassword))
				&& oWrap.verifyDisplayedwithReturn(driver.findElement(oSignIn))&& oWrap.verifyDisplayedwithReturn(driver.findElement(oRegister))) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public LoginPage typeUserName(String userName) {
		oWrap.type(driver.findElement(oUsername),userName);
		return this;
	}
	
	public LoginPage typePassword(String password) {
		oWrap.type(driver.findElement(oPassword),password);
		return this;
	}
	
	public HomePage clickSignIn() {
		oWrap.click(driver.findElement(oSignIn));
		return new HomePage(driver,node);
	}
	
	public LoginPage clickSignInFailed() {
		oWrap.click(driver.findElement(oSignIn));
		return this;
	}
	
	public RegistrationPage clickRegister() {
		oWrap.click(driver.findElement(oRegister));
		return new RegistrationPage(driver,node);
	}

}
