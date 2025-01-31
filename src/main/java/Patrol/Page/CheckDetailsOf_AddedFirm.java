package Patrol.Page;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;
import Patrol.Utility.UtilityClass;

public class CheckDetailsOf_AddedFirm extends BasePage {
	
	public CheckDetailsOf_AddedFirm(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
		
		@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div[3]/a")
		private WebElement ViewCompany;
		
		
		
		public void clickOnCauseList() {
			Library.click(driver, ViewCompany, "click on view company button");
		}

        	 
        	 public void verifyFirmsInTable() throws IOException, MessagingException 
        	 {
        		 for (int page = 1; page <= 2; page++) {
     	            System.out.println("Testing firms on page: " + page);

     	            // Get all firms on the current page
     	            List<WebElement> firmElements = driver.findElements(By.xpath("//*[@id=\"tab1\"]/div[1]/table/tbody/tr/td[2]/a")); 

     	            for (int i = 1; i <= firmElements.size(); i++) {
     	                try {
     	                    WebElement firm = driver.findElement(By.xpath("(//*[@id=\"tab1\"]/div[1]/table/tbody/tr/td[2]/a)[" + i + "]")); 
     	                    String firmName = firm.getText();
     	                    System.out.println("Clicking on firm: " + firmName);
     	                   JavascriptExecutor js = (JavascriptExecutor) driver;
     	                   js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", firm);
     			            Thread.sleep(500); 
     	                    firm.click();
     	                    Thread.sleep(1000);

     	                    // Check for errors
     	                    verifyTextOnPage(driver, "Stack trace");

     	                    driver.navigate().back();
     	                    Thread.sleep(1000);
     	                } catch (Exception e) {
     	                  //  String screenshotPath = UtilityClass.Capaturescreenshot(driver, "Error_Firm");
     	                   // sendErrorEmail("Error in Active Firm", "Error occurred while clicking on a firm.", screenshotPath);
     	                }
     	            }

     	            // Click next page button
     	            try {
     	                WebElement nextPage = driver.findElement(By.xpath("//*[@id=\"tab1\"]/div[2]/div/nav/div[1]/a")); // Update with correct XPath
     	                if (nextPage.isDisplayed()) {
     	                    nextPage.click();
     	                    Thread.sleep(3000);
     	                }
     	            } catch (Exception e) {
     	                System.out.println("No more pages available.");
     	                break;
     	            }
     	        }
     	    }

     	    private static void verifyTextOnPage(WebDriver driver, String searchText) throws IOException, MessagingException {
     	        try {
     	            WebElement errorElement = driver.findElement(By.xpath("//button[contains(text(), 'Stack trace')]"));
     	            if (errorElement.isDisplayed()) {
     	                System.out.println("Error coming on above Company");
     	                String screenshotPath = UtilityClass.Capaturescreenshot(driver, "Error_Screenshot");
     	               
     	    			String testUrl = driver.getCurrentUrl();  
     	   			 Patrol.Utility.ForMultiplemailReceipent.sendEmail(
     	   	            	   driver, new String[]{"ghodake6896@gmail.com"},
     	   	            	    "Patrol-  AddedFirm",
     	   	            	    "Please check issue coming on detail page of addedFirm please check below urlLink, please find the attached screenshot for details." ,
     	   	            	 screenshotPath,testUrl
     	   	            	   
     	   	            	);

     	    			return;
     	                
     	            }
     	        } catch (org.openqa.selenium.NoSuchElementException e) {
     	            return;
     	        }
     	    }
        	 
         }
	
	
	
	
	
	
	
	
	
	
	
	
	
	

