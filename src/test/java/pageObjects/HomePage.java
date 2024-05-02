package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		super(driver);	
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement myAccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement register;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement loginBtn;
	
	public void goToMyaccount()
	{
		
		myAccount.click();
	}
	
	public void goToRegister() {
		register.click();
		
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}

}
