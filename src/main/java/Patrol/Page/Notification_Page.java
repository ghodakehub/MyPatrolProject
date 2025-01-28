package Patrol.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class Notification_Page extends BasePage {
	

	public Notification_Page (WebDriver driver,ExtentTest test) {
		super(driver, test);
		
	}
	
	@FindBy (xpath = "(//a[@class='nav-link'])[11]")
	private WebElement NOTIFICATION;
	
	
	@FindBy (xpath = "//a[@class='nav-link py-3   ']")
	private WebElement NOTIFICATION_BAR;
	
	
	public void clickOnNotification() {
		Library.click(driver, NOTIFICATION, "clicked on notification element available on left side of main  page in blue window.");
	}
	
	public void verifyNotificationBarElement() {
	List<WebElement> barElements= driver.findElements(By.xpath("(//ul[@id='myTab']//li//a[@class='nav-link py-3   '])"));
	barElements.size();
		for (int i=1; i<=barElements.size();i++) {
			Library.threadSleep(1000);
			WebElement bar=driver.findElement(By.xpath("((//ul[@id='myTab']//li//a[@class='nav-link py-3   ']))["+i+"]"));
			String text=bar.getText();
			System.out.println("Element available on notification bar is:- "+bar.getText());
			bar.click();
            System.out.println("Succesfully clicked on "+text);	
			Library.implicitWait(driver, 20);
			
			verifyTextonPage(driver, "Stack trace");
			
			driver.navigate().back();
			Library.threadSleep(2000);
		}
	}
	
	private static void verifyTextonPage(WebDriver driver, String SearchText) {
	
		try {
		WebElement element= driver.findElement(By.xpath("//button[contains(text(), 'Stack trace')]"));
		System.out.println(" ");
		System.out.println("THERE IS AN ERROR ON ABOVE ELEMENT.");
		System.out.println(" ");
		return;
		}catch(org.openqa.selenium.NoSuchElementException e){
			return;
		}
		
	}
	
	
	
}
