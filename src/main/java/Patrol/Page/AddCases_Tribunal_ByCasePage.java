package Patrol.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.Library;

public class AddCases_Tribunal_ByCasePage extends BasePage{
	
	public AddCases_Tribunal_ByCasePage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "(//span[@class='position-relative'])[3]")
	private WebElement TRIBUNALS;
	
	@FindBy (xpath = "(//select[@class='form-select'])[1]")
	private WebElement COURT;
	
	@FindBy (xpath = "(//select[@class='form-select'])[4]")
	private WebElement YEAR;
	
	@FindBy (xpath = "(//input[@class='form-control'])[3]")
	private WebElement PARTY_NAME;
	
	@FindBy (xpath = "(//button[@class='btn btn-primary fs-14 '])[1]")
	private WebElement SEARCH_FOR_CASE_BUTTON;
	
	
	
	public void clickOnTribunals() {
		Library.click(driver, TRIBUNALS, "Clicked on tribunals on select forum page.");
	}
	
	public void selectCourt(String LogCourt) {
		Library.selectDropDown(COURT, LogCourt);
		System.out.println("Tribunals Court selected successfully.");
	}
	
	public void selectYear(String LogYear) {
		Library.selectDropDown(YEAR, LogYear);
		System.out.println("Year selcted successfully.");
	}
	
	public void enterPartyName(String LogPartyName) {
		Library.sendKeys(driver, PARTY_NAME, "Party Name sent successfully.", LogPartyName);
	}
	
	public void clickOnSearchButton() {
		Library.click(driver, SEARCH_FOR_CASE_BUTTON, "Clicked on search button successfully.");
		Library.threadSleep(5000);
	}
	
	
}
