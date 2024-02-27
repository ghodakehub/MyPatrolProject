package Patrol.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.Library;

public class AddCase_HC_ByAdvocatePage extends BasePage{
	
	public AddCase_HC_ByAdvocatePage(WebDriver driver){
		super(driver);
	}

	@FindBy (xpath = "(//button[@class='nav-link   fs-14 py-4 fw-bold'])[3]")
	private WebElement BY_ADVOCATE_NAME;
	
	@FindBy (xpath = "(//select[@class='form-select'])[10]")
	private WebElement COURT;
	
	@FindBy (xpath = "(//input[@class='form-control '])[3]")
	private WebElement ADVOCATE_TAB;
	
	@FindBy (xpath = "(//select[@class='form-select'])[13]")
	private WebElement YEAR;
	
	@FindBy (xpath = "(//button[@class='btn btn-primary fs-14 '])[4]")
	private WebElement SEARCH_FOR_CASE_BUTTON;
	
	@FindBy (xpath = "//label//span")
	private WebElement CHECK_BOX;
	
	@FindBy (xpath = "//button[@class='btn btn-primary btn-sm ms-auto']")
	private WebElement ADD_CASES_BUTTON;
	
	@FindBy (xpath =  "//BUTTON[@CLASS='swal2-confirm swal2-styled']")
	private WebElement OK_BUTTON;
	
	
	
	public void clickOnByAdvoacteName() {
		Library.click(driver, BY_ADVOCATE_NAME, "Clicked on by advocate name successfully.");
	}
	
	public void selectCourt(String LogCourt) {
		Library.selectDropDown(COURT, LogCourt);
	}
	
	public void enterAdvocateName(String LogAdvocate) {
		Library.sendKeys(driver, ADVOCATE_TAB, "Advocate name send successfully.", LogAdvocate);
	}
	
	public void selectYear(String LogYear) {
		Library.selectDropDown(YEAR, LogYear);
	}
	
	public void clickOnSearchCaseButton() {
		Library.click(driver, SEARCH_FOR_CASE_BUTTON, "Clicked on search for case successfully.");
		Library.threadSleep(5000);
	}
	
	public void selectCases (int LogNoOfCase) {
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
				Library.click(driver, ADD_CASES_BUTTON, "Clicked on Add cases Button successfully.");

				
	}
	
	public void clickOnOkButton() {
		Library.click(driver, OK_BUTTON, "Clicked on OK Boutton successfully.");
		Library.threadSleep(5000);
		}
	
	
	
	
	
	
	
}
