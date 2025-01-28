package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class Patrol_Company  extends BasePage {
	
	public Patrol_Company(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	
	
	 public void CheckSwitchCompany()
	 {
		 
		  Library.threadSleep(3000);
		  
		  
		 
		    WebElement switchCompany  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[8]/a/span"));
		   // notification.click();
		    
		    JavascriptExecutor js1 = (JavascriptExecutor)driver;
	 		js1.executeScript("arguments[0].scrollIntoView(true);",switchCompany );
	 		switchCompany.click();
	 		

		     Library.threadSleep(2000);
            // Verify if the title is displayed
            WebElement Activefirm = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1"));
            
            Library.threadSleep(2000);
           
            if (Activefirm.isDisplayed()) {
                System.out.println("Activefirm title is displayed. Activefirm page open successfully ,Test passed!");
            } else {
                System.out.println("Activefirm title is NOT displayed. Means error coming , Test failed!");
                Assert.fail("Activefirm title not display means It throw error while open it");
            }
       
		 
	 }

}
