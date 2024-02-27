package Patrol.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.Library;



public class AddCase_HC_ByPartyNamePage extends BasePage {
	
	public AddCase_HC_ByPartyNamePage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "(//button[@class='nav-link   fs-14 py-4 fw-bold'])[2]")
	private WebElement BY_PARTY_NAME;
	
	@FindBy (xpath = "(//select[@class='form-select'])[5]")
	private WebElement COURT;
	
	@FindBy (xpath = "(//select[@class='form-select'])[8]")
	private WebElement CASE_STATUS;
	
	@FindBy (xpath = "(//select[@class='form-select'])[9]")
	private WebElement YEAR;
	
	@FindBy (xpath = "(//input[@class='form-control '])[2]")
	private WebElement PARTY_NAME;
	
	@FindBy (xpath = "(//button[@class='btn btn-primary fs-14 '])[3]")
	private WebElement SEARCH_FOR_CASE;
	
	@FindBy (xpath = "//label//span")
	private WebElement CHECK_BOX;
	
	@FindBy (xpath = "//button[@class='btn btn-primary btn-sm ms-auto']")
	private WebElement ADD_CASES_BUTTON;
	
	@FindBy (xpath = "//button[@class='swal2-confirm swal2-styled']")
	private WebElement OK_BUTTON;
	
	
	
	public void clickOnPartyName() {
		Library.click(driver, BY_PARTY_NAME, "Clicked on By Party Name successfully.");
	//	Library.implicitWait(driver, 20);
		Library.threadSleep(5000);
	}
	
	public void selectCourt(String LogCourt) {
	Library.selectDropDown(COURT, LogCourt);	
	}
	
	public void selectCaseStatus(String LogCaseStatus) {
		Library.selectDropDown(CASE_STATUS, LogCaseStatus);
	}
	
	public void selectYear(String LogYear) {
		Library.selectDropDown(YEAR, LogYear);
	}
	
	public void enterPartyName(String LogPartyName) {
		Library.sendKeys(driver, PARTY_NAME, "Party name entered successfully.", LogPartyName);
	}
	
	public void clickOnSearchForCase() {
		Library.click(driver, SEARCH_FOR_CASE, "Clicked on search for case.");
		Library.threadSleep(5000);
	}
	
	public void selectCases(int LogNoOfCase) {
		
		List<WebElement> checkBox = null;
//		try {
			checkBox =driver.findElements(By.xpath("//label//span"));
			System.out.println(checkBox.size());
			
			for(int i=1; i<=LogNoOfCase; i++) {
				WebElement check_Box= driver.findElement(By.xpath("(//label//span)["+i+"]"));
				Library.click(driver, check_Box, "ClickOn case-"+check_Box.getText());
			}
			Library.threadSleep(2000);
			((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.bodyscrollTop)");
			Library.threadSleep(2000);
			//Library.implicitWait(driver, 20);
			Library.click(driver, ADD_CASES_BUTTON, "Clicked on Add cases Button successfully.");
//		}catch (Exception e) {
//			String ExpectedText = ""
//		}
//		
			
	}
	
	public void clickOnOkButton() {
		Library.click(driver, OK_BUTTON, "Clicked on OK Boutton successfully.");
		Library.threadSleep(5000);

	}
	
	
	
	
	
}
