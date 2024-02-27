package Patrol.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.Library;

public class AddCases_SC_ByPartyNamePage extends BasePage {

	public AddCases_SC_ByPartyNamePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//button[@class='nav-link   fs-14 py-4 fw-bold'])[1]")
	private WebElement BY_PARTY_NAME;

	@FindBy(xpath = "//input[@id='party_name']")
	private WebElement PARTY_NAME_TAB;

	@FindBy(xpath = "(//select[@class='form-select'])[5]")
	private WebElement YEAR3;

	@FindBy(xpath = "(//button[@class='btn btn-primary fs-14 '])[3]")
	private WebElement SEARCH_FOR_CASE;

	@FindBy(xpath = "//label//span")
	private WebElement CHECK_BOX;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm ms-auto']")
	private WebElement ADD_CASES_BUTTON;

	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
	private WebElement OK_BUTTON;

	
	
	public void clickOnPatyName() {
		Library.click(driver, BY_PARTY_NAME, "Click on By Party Name successfully.");
	}

	public void enterValueOnPartyNameTab(String LogValue) {
		Library.sendKeys(driver, PARTY_NAME_TAB, "Value sent in Party Name Tab", LogValue);
	}

	public void selectYear(String enterYear) {
		Library.selectDropDown(YEAR3, enterYear);
	}

	public void clickOnSearchCases() {
		Library.click(driver, SEARCH_FOR_CASE, "Click on search cases Successfully");
	}

	public void selectCases(int enterNoOfcase) {

		List<WebElement> checkBox = null;
		try {
			checkBox = driver.findElements(By.xpath("//label//span"));
			System.out.println(checkBox.size());

			for (int i = 1; i <= enterNoOfcase; i++) {
				WebElement check_Box = driver.findElement(By.xpath("(//label//span)[" + i + "]"));
				Library.click(driver, check_Box, "Click on case - " + check_Box.getText());

			}
			Library.threadSleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.bodyscrollTop)");
			Library.threadSleep(2000);
			Library.click(driver, ADD_CASES_BUTTON, "Clicked on Add Cases Button successfully.");

		} catch (Exception e) {
			String ExpectedText = "Currenly This searched case is not available. you can request for this case and will be add and notified once available";
			String ActualText = driver.findElement(By.xpath("//p[@style='color:red']")).getText();
			if (ExpectedText.contains(ActualText)) {
				System.out.println("Webpage text verified successfully, No case available. ");
				Library.threadSleep(2000);
			} else {
				System.out.println("Webpage text not as expected.");
			}

		} 

	}

}
