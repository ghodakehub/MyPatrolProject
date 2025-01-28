package Patrol.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class DashBoardPage extends BasePage
{
	public DashBoardPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
	@FindBy(how = How.XPATH, using = "//a[@class='fw-bold text-dark fs-14 stretched-link text-decoration-none']")
	private WebElement COMPANY;

	@FindBy(how = How.XPATH, using = "(//span[@class='fs-14 fw-semibold text-primary'])[1]")
	private WebElement TOTAL_CASES;

	@FindBy(how = How.XPATH, using = "(//span[@class='fs-14 fw-semibold text-primary'])[2]")
	private WebElement PEOPLE;

	@FindBy(how = How.XPATH, using = "(//span[@class='fs-14 fw-semibold text-primary'])[3]")
	private WebElement DOCUMENT;

	@FindBy(how = How.XPATH, using = "(//span[@class='fs-14 fw-semibold text-primary'])[4]")
	private WebElement MATTERS;

	@FindBy(how = How.XPATH, using = "(//span[@class='fs-14 fw-semibold text-primary'])[5]")
	private WebElement TASK;

	@FindBy(how = How.XPATH, using = "(//span[@class='fs-14 fw-semibold text-primary'])[6]")
	private WebElement INVOICES;

	public void clickOncompany(String CompanyName) {
		List<WebElement> elements = driver
				.findElements(By.xpath("//a[@class='fw-bold text-dark fs-14 stretched-link text-decoration-none']"));
		System.err.println("Total company " + elements.size());

		String searchQuery = CompanyName;
		for (WebElement element : elements) {
			try {
				String elementTxt = element.getText();

				if (elementTxt.equals(searchQuery)) {
					element.click();
					break;
				}
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	public void verifyText() {

		
		Library.implicitWait(driver, 20);
		Library.verifyText(driver, TOTAL_CASES, "Total Cases");
		Library.verifyText(driver, PEOPLE, "People");
		Library.verifyText(driver, DOCUMENT, "Documents");
		Library.verifyText(driver, MATTERS, "Matters");
		Library.verifyText(driver, TASK, "Tasks");
		Library.verifyText(driver, INVOICES, "Invoices");
		Library.implicitWait(driver, 20);

		
		
		
	}

}
