package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class Patrol_ChatPage extends BasePage {
	
	public Patrol_ChatPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	
	
	 public void CheckAI_Chat()
	 {
		 
		  Library.threadSleep(3000);
		 
		    WebElement chat  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[9]/a/span"));
		    Library.threadSleep(500);
		    JavascriptExecutor js1 = (JavascriptExecutor)driver;
	 		js1.executeScript("arguments[0].scrollIntoView(true);",chat );
	 		chat.click();
	 		
		     Library.threadSleep(2000);
            // Verify if the title is displayed
            WebElement ChatTitle = driver.findElement(By.xpath("//h4[contains(text(),'Your GPT-Powered AI assistant with unmatched legal knowledge!')]"));
            
            Library.threadSleep(2000);
           
            if (ChatTitle.isDisplayed()) {
                System.out.println("AI_CHAT page open successfully ,Test passed!");
            } else {
                System.out.println(" AI_CHAT page not open . Means error coming , Test failed!");
                Assert.fail("AI_CHAT title not display means It throw error while open it");
            }
       
		 
	 }

}
