package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Patrol.Utility.Library;

public class AddCases_SC_ByDiaryNumberPage extends BasePage {

	public AddCases_SC_ByDiaryNumberPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@class='fw-semibold fs-14 text-decoration-none d-inline-flex align-items-center']")
	private WebElement TOTAL_CASES_VIEW_ALL;
	@FindBy(xpath= " //a[@class='btn btn-primary text-nowrap me-2 h-100 px-3 d-flex align-items-center']")
	private WebElement ADD_CASES;
	@FindBy(xpath = "(//span[@class='position-relative'])[1]")
	private WebElement SUPREME_COURT;
	@FindBy(xpath = "//button[@class='nav-link fs-14 fw-bold py-4     active  px-4']")
	private WebElement BY_DIARY_NUMBER;
	@FindBy(xpath = "//input[@id='diary_no']")
	private WebElement DIARY_NO;
	@FindBy(xpath = "(//select[@class='form-select'])[1]")
	private WebElement YEAR;
	@FindBy(xpath = "(//button[@class='btn btn-primary fs-14 '])[1]")
	private WebElement SEARCH_FOR_CASE_BUTTON;
	@FindBy (xpath= "//*[@id=\"content\"]/div/div[5]/div/div/div/div/div[1]/div/label/span")
	private WebElement CHECK_BOX;
	@FindBy (xpath = "//button[@class='btn btn-primary btn-sm ms-auto']")
	private WebElement ADD_CASES_BUTTON;
	@FindBy (xpath = "(//button[@type='button'])[13]")
	private WebElement OK_BUTTON;
	
	
	
	
	public void clickOnTotalcases() {
		Library.click(driver, TOTAL_CASES_VIEW_ALL, "Cliked on Total cases.");
		Library.implicitWait(driver, 20);
	}

	public void clickOnAddCases() {
		Library.click(driver, ADD_CASES, "Clicked on Add cases.");
		Library.implicitWait(driver, 20);
	}

	public void clickOnSupremeCourt() {
		Library.click(driver, SUPREME_COURT, "Clicked on supreme court");
		Library.implicitWait(driver, 20);
	}

	public void enterDiaryNumber(String LogValue) {
		Library.sendKeys(driver, DIARY_NO, "Diary no entered", LogValue);
		Library.implicitWait(driver, 20);
	}

	public void selectYear(String LogValue) {
		Library.selectDropDown(YEAR, LogValue);
		Library.implicitWait(driver, 20);
	}

	public void performAction() {
		Library.click(driver, SEARCH_FOR_CASE_BUTTON, "Clicked on search case button.");
		//Library.threadSleep(5000);
		Library.implicitWait(driver, 20);
	}
	
	public void verifyAvailableCase() {
		
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
//		Library.click(driver, ADD_CASES_BUTTON, "Clicked on add cases button and cases added.");
//		Library.implicitWait(driver, 20);
//		
//		Library.click(driver, OK_BUTTON, "Clicked on ok button.");
//		Library.threadSleep(5000);
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void verifyAvailableCase() {
//		Library.implicitWait(driver, 20);
//		
//		WebElement element= driver.findElement(By.xpath("//p[@style='color:red']"));
//		
//		String searchQuery= "Currenly This searched case is not available. you can request for this case and will be add and notified once available";
//	//	for(WebElement element)
//		
//		
//	}
		
		
//
//		try {
//		//WebElement element=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[5]/div/div/div/div/div[1]/div/label/span"));
//		//Library.waitForVisibilityOf(driver, element);
//		if(driver.findElement(By.xpath("//*[@id=\\\"content\\\"]/div/div[5]/div/div/div/div/div[1]/div/label/span")) != null) {
//			Library.click(driver, CHECK_BOX, "Clicked on check box");
//			Library.implicitWait(driver, 20);
//			Library.click(driver, ADD_CASES_BUTTON, "Clicked on add case button and case added. ");
//			Library.implicitWait(driver, 20);
//			Library.click(driver, OK_BUTTON, "Clicked on Ok button.");
//			Library.threadSleep(5000);
//
//		}else {
//			System.out.println("Data not available.");
//		}
//		}catch(StaleElementReferenceException e){
//			e.printStackTrace();
//			
//		}
//		
//	}
//	
	
	
	
//	public void clickOnCheckBox() {
//		Library.click(driver, CHECK_BOX, "Clicked on check box.");
//		
//	}
//	
//	public void clickOnAddCasesButton() {
//		Library.click(driver, ADD_CASES_BUTTON, "Clicked on add cases button and cases added.");
//		Library.implicitWait(driver, 20);
//		
//		Library.click(driver, OK_BUTTON, "Clicked on ok button.");
//		Library.threadSleep(5000);
//	}
	
	
	
	
	
	
	
	
	
	
	
}
