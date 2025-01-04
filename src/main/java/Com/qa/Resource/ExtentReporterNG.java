package Com.qa.Resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	
static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		
	/*	   // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        
        // Format the date and time using a pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        
        // Print the formatted date and time
       // System.out.println("Current date and time: " + formattedDateTime);
		
        String path =System.getProperty("user.dir")+"/report/"+formattedDateTime;*/
        
		String path =System.getProperty("user.dir")+"/report/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName(" Framework Results");
		reporter.config().setDocumentTitle("Automation Execution Results");
		reporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Automation Engineer", "Demo Automation");
		extent.setSystemInfo("Operating System",System.getProperty("os.name"));
		extent.setSystemInfo("Operating System",System.getProperty("user.name"));
		//extent.setSystemInfo("Operating System",System.getProperty("java.version"));
		extent.setSystemInfo("Web Application Version ", "version = 2.10.4");
	
		return extent;
		
	}
//	public void m1() {
//		ExtentTest test=extent.createTest(" test1");
//		test.info("");
//	}
}


