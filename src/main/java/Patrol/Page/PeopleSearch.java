package Patrol.Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class PeopleSearch extends BasePage{
	
	public PeopleSearch(WebDriver driver,ExtentTest test) {
		super(driver, test);
			
	}

	@FindBy (xpath = "//*[@id=\"tab1-content\"]/div[1]/div[2]/div/div[2]/a/span")
	private WebElement People_ViewAll;
	
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/nav/a[2]")
	private WebElement Individuals;
	
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[3]/div[1]/div/div[1]/form/input")
	private WebElement Filterkeyword;
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/nav/a[1]")
	private WebElement All;
	
	@FindBy (xpath = "//*[@id=\"tab1\"]/nav/ul/li[3]/a")
	private WebElement pageno2;                   //textarea[@id='description']
	
	@FindBy (xpath = "//*[@id=\"tab1\"]/nav/ul/li[2]/a")
	private WebElement pageno1;
	
	public void clickOnPeopleViewAll(String companyName) throws InterruptedException {
		Library.click(driver,People_ViewAll , "Clicked on peopel view all button");
		Library.threadSleep(2000);
	 Filterkeyword.click();
	 Library.sendKeys(driver, Filterkeyword, "Find newly added company name :", companyName);
	 Library.threadSleep(2000);
	 Library.performEnterAction(Filterkeyword);

	 Library.click(driver,All , "Clicked on ALL tab");
	Library.threadSleep(2000);
	
	
	 JavascriptExecutor js1 = (JavascriptExecutor)driver;
	 js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
		js1.executeScript("arguments[0].scrollIntoView(true);",pageno2 );
		pageno2.click();
	
	Library.threadSleep(2000);
	
	 JavascriptExecutor js2 = (JavascriptExecutor)driver;
	 js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	 Library.threadSleep(2000);
		js2.executeScript("arguments[0].scrollIntoView(true);", pageno1);
		Library.threadSleep(2000);
		pageno1.click();
		
	}
}