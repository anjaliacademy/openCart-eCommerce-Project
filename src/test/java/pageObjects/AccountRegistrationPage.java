package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement fNameText;
	
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lNnameText;
	
	@FindBy(xpath="//input[@id='input-email']") WebElement emailText;
	
	@FindBy(xpath="//input[@id='input-telephone']") WebElement phoneText;
	
	@FindBy(xpath="//input[@id='input-password']") WebElement pwdText;
	
	@FindBy(xpath="//input[@id='input-confirm']") WebElement cPwdText;
	
	
	@FindBy(xpath="//input[@name='agree']") WebElement checkAgreement;
	
	@FindBy(xpath="//input[@class='btn btn-primary']") WebElement ctnBtn;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmMsg;
	
	
	public void enterFname(String firstname) {
		
		fNameText.sendKeys(firstname);
		
	}
	
public void enterLname(String lastname) {
		
	lNnameText.sendKeys(lastname);
		
	}

public void enterMail(String email) {
	
	emailText.sendKeys(email);
	
}

public void enterPhonenum(String phonenum) {
	
	phoneText.sendKeys(phonenum);
	
}

public void enterPwd(String pwd) {
	
	pwdText.sendKeys(pwd);
	
}

public void enterCpwd(String cPwd) {
	
	cPwdText.sendKeys(cPwd);
	
}

public void clickkAgreement() {
	
	checkAgreement.click();
	
	
}

public void clickkBtn() {
	

	
	ctnBtn.click();
	
}


public String checkMsg() {
	try {
		return(confirmMsg.getText());
	}catch(Exception e) {
		return(e.getMessage());
	}
	
}


}
	
	
	
	
	


