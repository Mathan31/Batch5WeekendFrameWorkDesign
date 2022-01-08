package testcases;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

public class TC002_Registration extends BaseClass{
	

	
	@Test(priority = 1)
	public void registrationFieldValidation() {
		boolean result = new LoginPage()
		.clickRegister()
		.fieldValidation();
		Assert.assertTrue(result);
		new RegistrationPage().clickLogin();
	}
	
	@Test(priority = 2)
	public void registerWithMandatoryField() {
		new LoginPage()
		.clickRegister()
		.enterFirstName("Mathan")
		.selectTitle("Mr")
		.enterMiddleName()
		.enterLastName("Chandrasekaran")
		.selectGender("Male")
		.enterUserName("Mathan"+generateRandomInt(100, 100000))
		.enterEmail("credo"+generateRandomInt(100, 100000)+"@gmail.com")
		.enterPassword("Testing123")
		.clickRegisterLink()
		.verifyUserRegistration()
		.clickOnLogin();
		 
	} 
	
	public int generateRandomInt(int min,int max) {
		Random r = new Random();
		int result = r.nextInt((max-min)+1)+min;
		return result;
	}

}
