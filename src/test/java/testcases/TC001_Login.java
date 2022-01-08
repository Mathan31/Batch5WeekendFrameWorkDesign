package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_Login extends BaseClass{
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage().verifyElement();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2)
	public void loginWithValidCredential() {
		new LoginPage()
			.typeUserName("Mathan")
			.typePassword("Testing123")
			.clickSignIn()
			.validateHomePage()
			.clickonLogout();
		 
	} 
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage()
		.typeUserName("mathan")
		.typePassword("test123")
		.clickSignInFailed()
		.verifyElement();
		Assert.assertTrue(result);
	}

}
