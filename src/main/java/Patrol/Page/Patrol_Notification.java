package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class Patrol_Notification extends BasePage {
	
	public Patrol_Notification(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	
	
	 public void checknotification()
	 {
		 
		  Library.threadSleep(3000);
		  
		  
		 
		    WebElement notification  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[7]/a/span"));
		   // notification.click();
		    
		    JavascriptExecutor js1 = (JavascriptExecutor)driver;
	 		js1.executeScript("arguments[0].scrollIntoView(true);",notification );
	 		notification.click();
	 		

		     Library.threadSleep(2000);
            // Verify if the title is displayed
            WebElement notificationTitle = driver.findElement(By.xpath("//h1[contains(text(),'Notification')]"));
            
            Library.threadSleep(2000);
           
            if (notificationTitle.isDisplayed()) {
                System.out.println("Notification title is displayed. Notification page open successfully ,Test passed!");
            } else {
                System.out.println("Notification title is NOT displayed. Means error coming , Test failed!");
                Assert.fail("Notification title not display means It throw error while open it");
            }
       
		 
	 }

}
