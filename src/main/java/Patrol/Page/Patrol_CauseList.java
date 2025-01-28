package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class Patrol_CauseList extends BasePage {
	
	public Patrol_CauseList(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	
	
	 public void CheckCauselist()
	 {
		 
		  Library.threadSleep(3000);
		 
		    WebElement causeList  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[4]/a/span"));
		    causeList.click();

		     Library.threadSleep(2000);
            // Verify if the title is displayed
            WebElement causelistTitle = driver.findElement(By.xpath("//h1[contains(text(),'Causelist')]"));
            
            Library.threadSleep(2000);
           
            if (causelistTitle.isDisplayed()) {
                System.out.println("CausesList title is displayed. CauseList page open successfully ,Test passed!");
            } else {
                System.out.println("CauseList title is NOT displayed. Means error coming , Test failed!");
                Assert.fail("CauseList title not display means It throw error while open it");
            }
       
		 
	 }
}
