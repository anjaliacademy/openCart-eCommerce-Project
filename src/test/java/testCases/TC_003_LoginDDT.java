package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void LoginDataDriven(String email,String password,String expectedRes) {
		logger.info("TC_003 is started");
		try {
		HomePage hp=new HomePage(driver);
		hp.goToMyaccount();
		hp.clickLoginBtn();
		
		LoginPage lp=new LoginPage(driver);
		lp.enterMail(email);
		lp.enterPwd(password);
		lp.clickLogin();
		
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetPage=map.checkMyAccount();
		
		if(expectedRes.equalsIgnoreCase("Valid")) {
			
			if(targetPage==true) {
				map.clickLogout();
				Assert.assertTrue(true);
			}
			else
				Assert.assertTrue(false);
		}
		
		
		if(expectedRes.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {
				map.clickLogout();
				Assert.assertTrue(false);
			}
			else
				Assert.assertTrue(true);
		}
		
		}
		catch(Exception e)
				{
			Assert.fail();
				}
		logger.info("TC_003 is completed");
	}
}
