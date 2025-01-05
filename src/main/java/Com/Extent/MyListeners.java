package Com.Extent;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Com.qa.base.TestBase;

public class MyListeners extends TestBase implements ITestListener {

	public MyListeners() throws IOException {
		super();
	}

	ExtentReports extentreport;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		extentreport = ER.generateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String TestName = result.getName();
		extentTest = extentreport.createTest(TestName);
		extentTest.log(Status.INFO, " Started Test Case :- " + TestName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String TestName = result.getName();
		extentTest.log(Status.PASS, TestName + " Test Case succefully executed  ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, TestName + " Test Case is Failed");
		try {
			extentTest.addScreenCaptureFromPath(getScreenShotPath(TestName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String TestName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, TestName + " Test Skippted  ");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" On Test Finished ");
		extentreport.flush();
		String path = System.getProperty("user.dir") + "\\report\\index.html";
		File URI = new File(path);
		try {
			Desktop.getDesktop().browse(URI.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
