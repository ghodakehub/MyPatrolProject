package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class Patrol_CalendarPage extends BasePage {
	
	public Patrol_CalendarPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	
	
	 public void CheckCalendar()
	 {
		 
		  Library.threadSleep(3000);
		  
		  
		 
		    WebElement ManageCases  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[2]/a/span"));
		    ManageCases.click();
		    Library.threadSleep(2000);
		    
		    
		    
		    WebElement calendar  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[2]/ul/li[3]/a/span"));
		   
		    JavascriptExecutor js1 = (JavascriptExecutor)driver;
	 		js1.executeScript("arguments[0].scrollIntoView(true);",calendar);
	 		calendar.click();
	 		
		    Library.threadSleep(2000);
		    
            // Verify if the title is displayed
            WebElement calendarTitle = driver.findElement(By.xpath("//h1[contains(text(),'Calendar')]"));
            
            Library.threadSleep(2000);
           
            if (calendarTitle.isDisplayed()) {
                System.out.println("Calendar title is displayed. Calendar page open successfully ,Test passed!");
            } else {
                System.out.println("Calendar title is NOT displayed. Means error coming , Test failed!");
                Assert.fail("Calendar title not display means It throw error while open it");
            }
       
		 
	 }

}
