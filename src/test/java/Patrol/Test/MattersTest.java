package Patrol.Test;

import java.io.IOException;

import org.testng.ITestResult;
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
import Patrol.Utility.UtilityClass;

public class MattersTest extends BaseTest{
	

	UtilityClass utility;
	String tcid;
	
	
	public static ExtentReports extent;
	
	public static ExtentSparkReporter spark;
	
	public static ExtentTest test;
	
	
	@BeforeMethod
	public void initialize()
	{
	  extent=ExtentReportManager.getReports();
	  test= extent.createTest("verify Matter module"); 
		
	}

	@Test
	
	public void makeNewMatter() {
		
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
		matterPage.selectCourt("District Case");
		matterPage.selectSearchCaseDropDown("NANAK SINGH vs GURDIP SINGH");
		matterPage.clickOnYesChangeButton();
		matterPage.clickOnNextButton();
		matterPage.selecpeople("Yashoda");
		matterPage.selectOrganisation("test1");
		matterPage.selectpracticearea("Criminal");
		matterPage.selecassinguser("pratiksha shinde");
		matterPage.selectdept("testing department");
		matterPage.enterdata();
		matterPage.enterstatus("Pending");
		matterPage.clickbtn("Flat Rate");
		
		
		
	}

	@AfterMethod()
	public void aftermethod(ITestResult result) throws  IOException
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "test case is failed"+result.getName());
			test.log(Status.FAIL, "test case is failed"+result.getThrowable());
			String screenshot=  UtilityClass.Capaturescreenshot(driver,result.getName() );
		
			test.log(Status.FAIL,"test"+ test.addScreenCaptureFromPath(screenshot));
		
		}
		
		else if(result.getStatus()== ITestResult.SKIP){
			
			
			test.log(Status.SKIP, "test case is skipped"+result.getName());
			

		}extent.flush();
		driver.quit();	
	}
		
	
	
	
}
