package Com.Extent;

import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ER {
	public static ExtentReports generateExtentReport() {
		ExtentReports extentreport = new ExtentReports();
		File extentReportfilePath = new File(System.getProperty("user.dir") + "/report/index.html");

		// Ensure the report directory exists
		File reportDir = new File(System.getProperty("user.dir") + "/report");
		if (!reportDir.exists()) {
			reportDir.mkdirs(); // Creates the directory if it doesn't exist
		}

		ExtentSparkReporter SparkreporterOB = new ExtentSparkReporter(extentReportfilePath);

		SparkreporterOB.config().setTheme(Theme.DARK);
		SparkreporterOB.config().setReportName("Demo Automation Reports");
		SparkreporterOB.config().setDocumentTitle("Automation Execution Results");

		extentreport.attachReporter(SparkreporterOB);
		extentreport.setSystemInfo("Application URL",
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		extentreport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentreport.setSystemInfo("System Name", System.getProperty("user.name"));
		extentreport.setSystemInfo("Java Version", System.getProperty("java.version"));

		return extentreport;
	}
}
