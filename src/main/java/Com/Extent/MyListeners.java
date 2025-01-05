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
		extentTest.log(Status.INFO, "Started Test Case: " + TestName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String TestName = result.getName();
		extentTest.log(Status.PASS, TestName + " Test Case successfully executed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, TestName + " Test Case Failed.");
		try {
			extentTest.addScreenCaptureFromPath(getScreenShotPath(TestName));
		} catch (IOException e) {
			extentTest.log(Status.INFO, "Error while capturing screenshot: " + e.getMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String TestName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, TestName + " Test Skipped.");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Test Finished.");
		extentreport.flush();

		File reportDir = new File(System.getProperty("user.dir") + "/report");
		if (!reportDir.exists()) {
			if (reportDir.mkdirs()) {
				System.out.println("Report directory created successfully.");
			} else {
				System.out.println("Failed to create report directory.");
			}
		}

		String path = System.getProperty("user.dir") + "/report/index.html";
		File URI = new File(path);
		try {
			Desktop.getDesktop().browse(URI.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
