package actitime.com.test.classes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import actitime.com.pom.classes.HomePage;
import actitime.com.pom.classes.LoginPage;
import utilities.Utility;

public class Actitime_TestClass{
	
	private WebDriver driver;
	private LoginPage loginpage;
	private HomePage homepage;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeClass
	public void beforeclass()
	{   
		reporter = new ExtentHtmlReporter("test-output//ExtendReport//Extent.html"); 
		ExtentReports extend = new ExtentReports();
		extend.attachReporter (reporter);
		System.out.println("launch the Actitime");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
	}
	
	@BeforeMethod
	public void beforemethod() throws InterruptedException
	{
		System.out.println("Login Actitime");
		loginpage = new LoginPage(driver);
		loginpage.sendUsername("admin");
		loginpage.sendPassword("manager");
		Thread.sleep(3000);
		loginpage.clickOnLogInButton();
	}
	
	@Test
	public void test1() throws InterruptedException
	{	Thread.sleep(3000);
		System.out.println("Verify Tasks Button");
		homepage = new HomePage (driver);
		homepage.clickOnTasks();
		String url = driver.getCurrentUrl();
		if(url.equals("http://localhost/tasks/otasklist.do"))
		{
			System.out.println("Test1 : Pass");
		}
		else
		{
			System.out.println("Test1 : Fail");
		}
		
	}
	
	@Test
	public void test2() throws InterruptedException
	{	Thread.sleep(3000);
		System.out.println("Verify ReportButton");
		homepage = new HomePage (driver);
		homepage.clickOnReports();
		String url = driver.getCurrentUrl();
		if(url.equals("http://localhost/reports/reports.do"))
		{
			System.out.println("Test2 : Pass");
		}
		else
		{
			System.out.println("Test2 : Fail");
		}
	}
	
	@Test
	public void test3() throws InterruptedException
	{	Thread.sleep(3000);
		System.out.println("Verify ReportButton");
		homepage = new HomePage (driver);
		homepage.clickOnReports();
		String url = driver.getCurrentUrl();
		if(url.equals("http://localhost/reports/reports.do"))
		{
			System.out.println("Test3 : Pass");
		}
		else
		{
			System.out.println("Test3 : Fail");
		}
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws InterruptedException, IOException
	{	
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.takeScreenshot(driver);
		}
		System.out.println("Logout Actitime");
		Thread.sleep(3000);
		homepage.clickOnLogout();
	}
	
	@AfterClass
	public void afterclass() throws InterruptedException
	{	Thread.sleep(3000);
		driver.close();
	}
}
