package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public WebDriver driver;
	
	public MyAccountPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")  WebElement myAccount;
	@FindBy(xpath="//div[@class='list-group']//a[13]") WebElement logout;
	
	public boolean checkMyAccount() {
		try {
			return(myAccount.isDisplayed());
		}catch(Exception e){
			return(false);
		}
	}
	
	public void clickLogout() {
		logout.click();
	}

}
