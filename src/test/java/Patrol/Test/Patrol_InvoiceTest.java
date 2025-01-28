package Patrol.Test;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ExtentReportBasic.ExtentReportManager;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.Patrol_Invoice;
import Patrol.Utility.BaseTest;
import Patrol.Utility.UtilityClass;

public class Patrol_InvoiceTest extends BaseTest {
	

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
	
	public void verifyNotification() {
		
		LoginPage loginPage = new LoginPage(driver,test);
		loginPage.setEmail(Email);
		loginPage.setPassword(Password);
		loginPage.performAction();

		DashBoardPage dashBoardpage = new DashBoardPage(driver,test);
		dashBoardpage.clickOncompany("Legitquest");
		
		Patrol_Invoice Invoice= new Patrol_Invoice(driver,test);
		Invoice.checkinvoice();
	}
	
	@AfterMethod
	
	public void aftermethod(ITestResult result) throws  IOException, MessagingException
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "test case is failed"+result.getName());
			test.log(Status.FAIL, "test case is failed"+result.getThrowable());
			String screenshot=  UtilityClass.Capaturescreenshot(driver,result.getName() );
		
			test.log(Status.FAIL,"test"+ test.addScreenCaptureFromPath(screenshot));
			
			
			String testUrl = driver.getCurrentUrl();  
			 Patrol.Utility.ForMultiplemailReceipent.sendEmail(
	            	   driver, new String[]{"ghodake6896@gmail.com"},
	            	    "Patrol- Invoice ",
	            	    "Please check Patrol Invoice not working showing error , please find the attached screenshot for details." ,
	            	    screenshot,testUrl
	            	   
	            	);
		
		
		
		}
		
		else if(result.getStatus()== ITestResult.SKIP){
			
			
			test.log(Status.SKIP, "test case is skipped"+result.getName());
			

		}extent.flush(); // Flush the report
    
		driver.quit();	
		}
	


}
