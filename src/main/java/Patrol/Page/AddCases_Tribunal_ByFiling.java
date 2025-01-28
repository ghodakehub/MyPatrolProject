package Patrol.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

public class AddCases_Tribunal_ByFiling extends BasePage {
	
	AddCases_Tribunal_ByFiling (WebDriver driver,ExtentTest test) {
		super(driver, test);
	}

	@FindBy (xpath = "//button[@class='nav-link   fs-14 py-4 fw-bold']")
	private WebElement BY_FILLING_NUMBER;
	
	
	
	
	
	
	
	
	
	
	
}
