package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class Patrol_Invoice extends BasePage {
	
	public Patrol_Invoice(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	
	
	 public void checkinvoice()
	 {
		 
		  Library.threadSleep(3000);
		 
		    WebElement invoice  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[5]/a/span"));
		    invoice.click();

		     Library.threadSleep(2000);
            // Verify if the title is displayed
            WebElement InvoiceTitle = driver.findElement(By.xpath("//h1[contains(text(),'Invoice')]"));
            
            Library.threadSleep(2000);
           
            if (InvoiceTitle.isDisplayed()) {
                System.out.println("Invoice title is displayed. Invoice page open successfully ,Test passed!");
            } else {
                System.out.println("Invoice title is NOT displayed. Means error coming , Test failed!");
                Assert.fail("Invoice title not display means It throw error while open it");
            }
       
		 
	 }

}
