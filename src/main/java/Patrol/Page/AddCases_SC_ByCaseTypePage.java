package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.Library;

public class AddCases_SC_ByCaseTypePage extends BasePage {
	
	public AddCases_SC_ByCaseTypePage(WebDriver driver) {
		super(driver);
	}

	

	@FindBy (xpath = "//button[@class='nav-link   fs-14 py-4 fw-bold ']")
	private WebElement BY_CASE_TYPE;
	
	@FindBy (xpath = "(//select[@class='form-select'])[2]")
	private WebElement CASE_TYPE;
	
	@FindBy (xpath = "(//input[@class='form-control'])[7]")
	private WebElement CASE_NO;
	
	@FindBy (xpath = "(//select[@class='form-select'])[3]")
	private WebElement YEAR_2;
	
	@FindBy (xpath = "(//button[@class='btn btn-primary fs-14 '])[2]")
	private WebElement SEARCH_FOR_CASE_BUTTON2;
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[5]/div/div/div/div/div[1]/div/label/span")
	private WebElement CHECK_BOX;
	
	@FindBy (xpath = "//button[@class='btn btn-primary btn-sm ms-auto']")
	private WebElement ADD_CASES_BUTTON;
	
	@FindBy (xpath = "//button[@class='swal2-confirm swal2-styled']")
	private WebElement OK_BUTTON;
	
	
	
	
	public void clickOnByCaseType() {
		Library.click(driver, BY_CASE_TYPE, "Clicked on By-Case-Type.");
	}
	
	public void selectCasetype(String enterValueInUpperLatter) {
		Library.selectDropDown(CASE_TYPE, enterValueInUpperLatter);
	}
	
	public void enterCaseNo(String enterValue) {
		Library.sendKeys(driver, CASE_NO, "Entered value- "+enterValue, enterValue);
	}
	
	public void selectYear2(String enterYear) {
		Library.selectDropDown(YEAR_2, enterYear);
	}
	
	public void performAction2() {
		Library.click(driver, SEARCH_FOR_CASE_BUTTON2, "Clicked on sesrch button.");
	}
	
	public void verifyAvailableCases() {
		
		WebElement checkBox = null;
		try {
			checkBox = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[5]/div/div/div/div/div[1]/div/label/span"));
			checkBox.click();
			System.out.println("Check box click successfully.");
			Library.threadSleep(2000);
			Library.click(driver, ADD_CASES_BUTTON, "Clicked ok AddCases Button successfully.");
			Library.click(driver, OK_BUTTON, "Clicked on Ok Button successfully.");
		}catch(Exception e) {
			String expectedText = "Currenly This searched case is not available. you can request for this case and will be add and notified once available";
			String actualText   = driver.findElement(By.xpath("//p[@style='color:red']")).getText();
			if (actualText.contains(expectedText)) {
				System.out.println("Webpage text verified successfully, No case available. ");
				Library.threadSleep(2000);
			}else {
				System.out.println("Webpage text not as expected.");
			}
			
		}
		
	}

	
//	public void clickOnAddCasesButton() {
//		Library.click(driver, ADD_CASES_BUTTON, "Clicked on Add Cases Button");
//		Library.threadSleep(5000);
//	}
//	
	
}
