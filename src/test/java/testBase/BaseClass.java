package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseClass {
	
static public WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass(groups= {"regression","sanity","master"})
	@Parameters({"os","browser"})
	public void luanchBrowser(String os,String br) throws IOException {
	
		logger=LogManager.getLogger(this.getClass());
		
		FileReader file=new FileReader(".\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN10);
			}else if(os.equalsIgnoreCase("mac")) {
				
				cap.setPlatform(Platform.MAC);
			}else
			{
				System.out.println("no matching os");
				return;
			}
			
		
		
		//browser
		
	switch(br.toLowerCase()) {
	case "chrome": cap.setBrowserName("chrome");break;
	case "edge": cap.setBrowserName("MicrosoftEdge");break;
	default:System.out.println("no matching browser");return;
	}
	
	driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
	
		}
		
		else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			default: System.out.println("No matching browser..");
						return;
			}
			
		}
	
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass(groups= {"regression","sanity","master"})
	public void tearDown() {
		driver.quit();
	}
	
	
	public String generateRandomName() {
		String randomName=RandomStringUtils.randomAlphabetic(3);
		return randomName;
		
	}
	
	public String genrateRandomNumber() {
		String randomNumber=RandomStringUtils.randomNumeric(10);
		return randomNumber;
	}
	
	public String genrateRandomAlphaNumeric() {
		String randomAlphaNumeric=RandomStringUtils.randomAlphanumeric(5);
		return randomAlphaNumeric;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	

}
