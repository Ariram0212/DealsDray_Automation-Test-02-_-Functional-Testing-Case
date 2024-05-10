package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import datautility.DataUtility;

public class BaseClass {
	public WebDriver driver;
	DataUtility data=new DataUtility();
	@BeforeClass(alwaysRun=true)
	public void openBrowser() throws IOException
	{
		
		driver=new ChromeDriver();
		String url=data.fetchData("url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Reporter.log("Browser opened Successfully", true);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void logIn() throws IOException
	{
		
		driver.findElement(By.id("mui-1")).sendKeys(data.fetchData("username"));;
		driver.findElement(By.id("mui-2")).sendKeys(data.fetchData("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Reporter.log("Login Successfully", true);
	}
	
	@AfterMethod(alwaysRun=true)
	public void logOut()
	{
		driver.findElement(By.xpath("//strong[text()='PREXO-MIS-ADMIN']")).click();
		driver.findElement(By.xpath("//span[text()=' Logout ']")).click();
		Reporter.log("Logout Successfully", true);
	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("Browser Closed Successfully", true);
	}
	
}