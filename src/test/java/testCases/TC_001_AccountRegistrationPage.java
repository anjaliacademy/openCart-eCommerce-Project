package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationPage extends BaseClass{
	
	
	
	
	@Test(groups= {"regression","master"})
	public void accountCreation() {
		
	
		logger.info("***** Account registration test cases Started***");
		
		try {
			
		HomePage hp=new HomePage(driver);
		logger.info("Clicked on myaccount btn..  ");
		hp.goToMyaccount();
		logger.info("clicked on registration btn..");
		hp.goToRegister();
		
		logger.info("Enterning registration details in page..");
		AccountRegistrationPage aReg=new AccountRegistrationPage(driver);
		aReg.enterFname(generateRandomName().toUpperCase());
		aReg.enterLname(generateRandomName().toUpperCase());
		aReg.enterMail(generateRandomName()+"@gmail.com");
		aReg.enterPhonenum(genrateRandomNumber());
		
		String password=genrateRandomAlphaNumeric();
		aReg.enterPwd(password);
		aReg.enterCpwd(password);
		
		aReg.clickkAgreement();
		logger.info("clicked on continue btn..");
		aReg.clickkBtn();
		
		
		String msg=aReg.checkMsg();
		
		if(msg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			logger.info("msg is as expected.");
		}
		else {
			logger.error("msg is not as expected so,..test is failed..!");
			Assert.fail();
			
		}
		//Assert.assertEquals(msg, "Your Account Has Been Created!");
		
		}
		catch(Exception e) {
			logger.error("test failed.");
			Assert.fail();
		}
		logger.info("***Test case is completed****");
		
	}
	
	
	

}
