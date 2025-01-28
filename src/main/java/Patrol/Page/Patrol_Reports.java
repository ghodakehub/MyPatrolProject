package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class Patrol_Reports extends BasePage {
	
	public Patrol_Reports(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
	
	 public void testNavigationOptions() {

		   Library.threadSleep(3000);
             WebElement reports  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[3]/a/span"));
             reports.click();
             Library.threadSleep(1000);
             // Verify if the title is displayed
             WebElement reportsTitle = driver.findElement(By.xpath("//h1[contains(text(),'Report')]"));
            
             if (reportsTitle.isDisplayed()) {
                 System.out.println("Reports title is displayed. Test passed!");
             } else {
                 System.out.println("Reports title is NOT displayed. Test failed!");
                 Assert.fail("Report not working means issue coming while open Reports");
             }
        
	 }
}
		


