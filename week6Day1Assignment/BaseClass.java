package week6Day1Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public RemoteWebDriver driver;
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void preCondition(String browser, String url, String username, String password) throws InterruptedException
	{
	        //1. Launch URL "http://leaftaps.com/opentaps/control/login"
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
			driver.get(url);
			driver.manage().window().maximize();
			
			//2.(a) Enter value to UserName field "username = "demosalesManager""
			WebElement userNameTextBox = driver.findElement(By.id("username"));
			userNameTextBox.sendKeys(username);
			//Thread.sleep(3000);
			
			//2. (b) Enter value to PassWord field "password = "crmsfa""
			WebElement passwordTextBox = driver.findElement(By.id("password"));
			passwordTextBox.sendKeys(password);
			//Thread.sleep(3000);
			
			//3. Click on loginButton
			WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
			loginButton.click();
			Thread.sleep(3000);
			
			//4. Click on CRM/SFA link
			WebElement linkText = driver.findElement(By.linkText("CRM/SFA"));
			linkText.click();
			//Thread.sleep(3000);
			
			//5. Click on leadsButton		
			WebElement leadsButton = driver.findElement(By.linkText("Leads"));
			leadsButton.click();
			//Thread.sleep(3000);
	}
	
	@AfterMethod
	public void postConditon()
	{
		driver.close();
	}

}
