package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class Patrol_OrderTracker extends BasePage {
	
	public Patrol_OrderTracker(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	
	
	 public void checkordertrack()
	 {
		 
		 Library.threadSleep(3000);
		    WebElement causeList  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[6]/a/span"));
		    causeList.click();

		     //Library.threadSleep(2000);
            // Verify if the title is displayed
            WebElement ordertrack = driver.findElement(By.xpath("//h1[contains(text(),'Order Tracker')]"));
            
            Library.threadSleep(2000);
           
            if (ordertrack.isDisplayed()) {
                System.out.println("OrderTrack title is displayed. OrderTrack page open successfully ,Test passed!");
            } else {
                //System.out.println("OrdreTrack title is NOT displayed. Means error coming , Test failed!");
                Assert.fail("OrderTrack title not display means It throw error while open it");
            }
       
		 


	 }
}
