package actitime.com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	@FindBy (xpath="(//div[@class='label'])[2]")
	private WebElement Tasks;
	
	@FindBy (xpath="(//div[@class='label'])[3]")
	private WebElement Reports;
	
	@FindBy (xpath="(//div[@class='label'])[4]")
	private WebElement Users ;
	
	@FindBy (xpath="//a[@class='logout']")
	private WebElement logout ;
	
	public HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTasks ()
	{
		Tasks.click();
	}
	
	public void clickOnReports ()
	{
		Reports.click();
	}
	
	public void clickOnUsers ()
	{
		Users.click();
	}
	
	public void clickOnLogout ()
	{
		logout.click();
	}
}
