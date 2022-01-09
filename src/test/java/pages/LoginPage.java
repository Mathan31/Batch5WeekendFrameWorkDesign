package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	private By oUsername = By.id("username");
	private By oPassword = By.id("password");
	private By oSignIn = By.xpath("//button[text()='Sign In']");
	private By oRegister = By.xpath("//*[text()='Register For Account']");
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyElement() {
		if(driver.findElement(oUsername).isDisplayed() && driver.findElement(oPassword).isDisplayed()
				&& driver.findElement(oSignIn).isDisplayed()&& driver.findElement(oRegister).isDisplayed()) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public LoginPage typeUserName(String userName) {
		driver.findElement(oUsername).sendKeys(userName);
		return this;
	}
	
	public LoginPage typePassword(String userName) {
		driver.findElement(oPassword).sendKeys(userName);
		return this;
	}
	
	public HomePage clickSignIn() {
		driver.findElement(oSignIn).click();
		return new HomePage(driver);
	}
	
	public LoginPage clickSignInFailed() {
		driver.findElement(oSignIn).click();
		return this;
	}
	
	public RegistrationPage clickRegister() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(oRegister).click();
		return new RegistrationPage(driver);
	}

}
