package listenersPackage;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import basePackage.TestBase;
import utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener  {

	public void onTestStart(ITestResult result) 
	
	{
	   test=extent.startTest(result.getName().toUpperCase())	; 
	}

	public void onTestSuccess(ITestResult result) {
		 test.log(LogStatus.PASS,result.getName().toUpperCase()+"PASS") ;
		 extent.endTest(test);
         extent.flush();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.setProperty("org.uncommons.reportng.escape-output","false");
		 
		try {
			TestUtil.CapTureScreenshot();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}

		 test.log(LogStatus.FAIL,result.getName().toUpperCase()+"Fail with exception" + result.getThrowable()) ;
		 test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenShotName)) ;
			
		 extent.endTest(test);
         extent.flush();

		
		
		
		Reporter.log("Capturing Screenshot");
		 Reporter.log("<a target=\"_blank\"href="+TestUtil.screenShotName+">Screenshot</a>");
		 Reporter.log("<br>");
		 Reporter.log("<a target=\"_blank\"href="+TestUtil.screenShotName+"><img src= "+TestUtil.screenShotName+" height=200 width=200></img></a>");
		
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		 
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		 
	}

}
