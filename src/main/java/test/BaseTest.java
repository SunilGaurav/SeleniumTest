package test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.BrowserFactory;

public class BaseTest {

public WebDriver driver;
public ExtentReports report;
public ExtentTest logger;

@BeforeSuite
    public void setupSuite(){
    report = new ExtentReports (System.getProperty("user.dir") +"/test-output/SimplilearnReport.html", true);
    report
            .addSystemInfo("Host Name", "Simplilearn")
            .addSystemInfo("Environment", "Automation Testing")
            .addSystemInfo("User Name", "S Gaurav");

}

@BeforeClass
    public void setup(){

    driver = BrowserFactory.getDriver();
    driver.get("https://www.redbus.in/");

}
@AfterMethod
public void getResult(ITestResult result){

    if(result.getStatus()==ITestResult.FAILURE){
        logger.log(LogStatus.FAIL , "Test is Failed which started at :"+logger.getStartedTime()+" And ended at"+logger.getEndedTime());
    }
}

    @AfterTest
    public void publishReport() { 
        report.endTest(logger);
        report.flush();
        driver.quit();
    }

}
