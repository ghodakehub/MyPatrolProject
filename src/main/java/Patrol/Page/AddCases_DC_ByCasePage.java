package Patrol.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.Library;

public class AddCases_DC_ByCasePage extends BasePage {

	public AddCases_DC_ByCasePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//span[@class='position-relative'])[4]")
	private WebElement DISTRICT_COURTS;

	@FindBy(xpath = "//select[@class='form-select']")
	private WebElement STATE_DROPDOWN;

	@FindBy(xpath = "(//select[@class='form-select'])[2]")
	private WebElement DISTRICT_DROPDOWN;

	@FindBy(xpath = "(//select[@class='form-select'])[3]")
	private WebElement FORUM_DROPDOWN;

	@FindBy(xpath = "(//select[@class='form-select'])[4]")
	private WebElement CASE_TYPE_DROPDOWN;

	@FindBy(xpath = "(//input[@class='form-control'])[3]")
	private WebElement CASE_NO;

	@FindBy(xpath = "(//select[@class='form-select'])[5]")
	private WebElement YEAR_DROPDOWN;

	@FindBy (xpath = "//button[@class='btn btn-primary fs-14 ']")
	private WebElement SEARCH_FOR_CASE;
	
	@FindBy (xpath = "//label//span")
	private WebElement CHECK_BOX;
	
	@FindBy (xpath = "//button[@class='btn btn-primary btn-sm ms-auto']")
	private WebElement ADD_CASE_BUTTON;
	
	
	public void clickOnDistrictCourts() {
		Library.click(driver, DISTRICT_COURTS, "Clicked On District Courts successfully.");
	}

	public void selectState(String LogState) {
		Library.selectDropDown(STATE_DROPDOWN, LogState);
		System.out.println("State selected from dropdown successfully.");
	}

	public void selectDistrict(String LogDistrict) {
		Library.selectDropDown(DISTRICT_DROPDOWN, LogDistrict);
		System.out.println("District selected from dropdown successfully.");
	}
	
	public void selectForum(String LogForum) {
		Library.selectDropDown(FORUM_DROPDOWN, LogForum);
		System.out.println("Forum selected from dropdown successfully.");
	}
	
	public void selectCaseType(String LogCaseType) {
		Library.selectDropDown(CASE_TYPE_DROPDOWN, LogCaseType);
	}
	
	public void enterCaseNo(String LogCaseNo) {
		Library.sendKeys(driver, CASE_NO, "Case No send successfully.", LogCaseNo);
	}
	
	public void  selectYear(String LogYear) {
		Library.selectDropDown(YEAR_DROPDOWN, LogYear);
		System.out.println("Year selected successfully.");
		Library.threadSleep(5000);
	}
	
	public void clickOnsearchButton() {
		Library.click(driver, SEARCH_FOR_CASE, "Clicked on search button successfully.");
		Library.threadSleep(5000);
	}
	
	public void clickOnCheckBox() {
		Library.click(driver, CHECK_BOX, "Clicked on check box successfully.");
	}
	
	public void clickOnAddCases() {
		Library.click(driver, ADD_CASE_BUTTON, "Clicked on Add Cases button");
		Library.threadSleep(5000);
	}
	
}
