package Patrol.Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class addActiveFrim extends BasePage {

	public addActiveFrim (WebDriver driver,ExtentTest test) {
		super(driver, test);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"dashboardTitle\"]/text()")
	private WebElement dasbhoard;
	


	public void checkCompany() throws InterruptedException {
		try {
		
		  // Locate all active firms
        List<WebElement> firms = driver.findElements(By.xpath("//a[@class='fw-bold text-dark fs-14 stretched-link text-decoration-none']"));
        int totalFirms = firms.size();
        test.info("Total active firms found: " + totalFirms);
        Thread.sleep(1000);            
        for (int i = 0; i < firms.size(); i++) {
            try {
                // Refresh the list of companies (important when navigating back)
            	firms = driver.findElements(By.xpath("//a[@class='fw-bold text-dark fs-14 stretched-link text-decoration-none']"));

                // Click on the company link
                WebElement company = firms.get(i);
                String companyName = company.getText();
                System.out.println("Opening company: " + companyName);
                test.info("Opening comapny : " + companyName);
                company.click();

                // Wait for the company page to load
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

                // Check for "Master Dashboard" text
                try {
                    WebElement masterDashboard = driver.findElement(By.xpath("(//*[contains(text(),'Master Dashboard')])[1]"));
                    if (masterDashboard.isDisplayed()) {
                        System.out.println(companyName + ": Page loaded and home page open successfully ");
                        test.pass("Open comapny successfully :" + companyName);
                    }
                } catch (NoSuchElementException e) {
                    System.out.println(companyName + ": Error is throw when we select the company");
                    test.fail("Please check error coming while open this company : " + companyName);
                }
                driver.navigate().back();
                Thread.sleep(2000);
            } catch (Exception e) {
                test.fail("Exception occurred while checking firm: " + e.getMessage());
            }
        }
    } catch (Exception e) {
        test.fail("Test failed due to an unexpected error: " + e.getMessage());
    } 
}
    }
	          


