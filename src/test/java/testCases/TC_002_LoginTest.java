package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	
	@Test(groups= {"sanity","master"})
 public void verifyLogin() {
	 logger.info("***Started TC_002_LoginTest*****");
	 logger.debug("****debug started***");
	 
	 try {
	 logger.info("calling homePage pageObject!!!");
	 HomePage hp=new HomePage(driver) ;
	 
	 hp.goToMyaccount(); 
	 logger.info("clicked on myAcount.");
	 
	 hp.clickLoginBtn();
	 logger.info("clicked on loginBtn under MyAccount.");
	 
	 
	 logger.info("calling loginPage pageObject!!!");
	 LoginPage lp=new LoginPage(driver);
	 lp.enterMail(p.getProperty("email"));
	 lp.enterPwd(p.getProperty("password"));
	 logger.info("entered email and password");
	 
	 lp.clickLogin();
	 logger.info("clicked login to MyAccountPage..!!");
	 
	 
	 logger.info("calling MyAccountpage pageObject!!!");
	 MyAccountPage map=new MyAccountPage(driver);
	 
	 boolean targetPage=map.checkMyAccount();
	 if(targetPage==true) {
		 logger.info("targer myAcoount page is detected..!!");
		 Assert.assertTrue(true);	 
	 }else {
		 logger.info("target myAccountpage is not detected..!!");
		 Assert.fail();
	 }
	 
	
	logger.info("TC_002 ran succesfully ..!!");
	 }
	 catch(Exception e) {
		 Assert.fail();
	 }
	 
 }

}
