package Patrol.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ExtentReportBasic.ExtentReportManager;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.MatterPage;
import Patrol.Utility.BaseTest;
import Patrol.Utility.Library;
import Patrol.Utility.UtilityClass;

public class MatterforDrat  extends BaseTest{


	
	UtilityClass utility;
	String tcid;
	
	
	public static ExtentReports extent;
	
	public static ExtentSparkReporter spark;
	
	public static ExtentTest test;
	
	
	@BeforeMethod
	public void initialize()
	{
	  extent=ExtentReportManager.getReports();
	  test= extent.createTest("verify created matter for tirbunal courts"); 
		
	}

	@Test(priority =1)
	
	public void makeNewMatterforTribunal() {
		
		LoginPage loginpage = new LoginPage(driver,test);
		loginpage.setEmail(Email);
		loginpage.setPassword(Password);
		loginpage.performAction();
		utility=new UtilityClass();
		
		DashBoardPage dashBoardpage = new DashBoardPage(driver,test);
		dashBoardpage.clickOncompany("Legitquest");
		
		MatterPage matterPage = new MatterPage(driver,test);
		matterPage.clickOnMatterViewAll();
		matterPage.verifyTaskBarOfMatters();
		matterPage.clickOnNewMatterButton();
		matterPage.selectCourt("Tribunals");
		matterPage.selectSubCourt("DRAT");
		matterPage.selectSearchCaseDropDown("B S RAVISHANKAR vs CORPORATION BANK");
		matterPage.clickOnYesChangeButton();
		matterPage.clickOnNextButton();
		matterPage.selecpeople("Vikas"); 
		matterPage.selectOrganisation("test2");
		matterPage.selectpracticearea("Tax");
		matterPage.selecassinguser("pratiksha shinde");
		matterPage.selectdept("testing department");
		matterPage.enterdata();
		matterPage.enterstatus("Open");
		matterPage.clickbtn("Flat Rate");
		matterPage.geterrormessge();
		
  	
	}
	
	
	
	@AfterMethod()
	public void aftermethod(ITestResult result) throws  IOException
	{
		ExtentTest test = extent.createTest("Error Detection Test");
		
		// Log the error and attach the screenshot
		test.fail("Error detected: View [cases.tribunals.detail_drat] not found.");
		if(result.getStatus()== ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "test case is failed"+result.getName());
			test.log(Status.FAIL, "test case is failed"+result.getThrowable());
			UtilityClass.Capaturescreenshot(driver, UtilityClass.Capaturescreenshot(driver,screenshot ));
			test.log(Status.FAIL, (Markup) test.addScreenCaptureFromPath(screenshot));
		
		}
		
		else if(result.getStatus()== ITestResult.SKIP){
			
			
			test.log(Status.FAIL, "test case is skipped"+result.getName());
			

		}extent.flush();
	driver.quit();	
}
}