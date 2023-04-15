package Day13_04082023;

import ReusableLibrary.ReusableAnnotations;
import ReusableLibrary.ReusableMethods;
import ReusableLibrary.ReusableMethods_Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class T1_GoogleSearch_Logger extends ReusableAnnotations {
    ExtentReports reports = new ExtentReports("src/main/java/HTML_Report/automationReport.html",true);
    ExtentTest logger;
    @Test(priority = 1)
    public void searchForCricket(){
        //give a name to the test
        logger = reports.startTest("Search for Cricket");
        //navigate to Google home
        logger.log(LogStatus.INFO,"Navigate to Google home page");
        driver.navigate().to("https://www.google.com");
        //type the word cricket on the search field
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@name='q']","cricket",logger,"Search field");
        //hit submit on Google search
        ReusableMethods_Logger.submitMethod(driver,"//*[@name='btnK']",logger,"Google Search Button");
    }//end of test 1

    @Test(priority = 2)
    public void printOutSearchNumber(){
        logger = reports.startTest("Print Search Number for Cricket");
        //capture the search result
        String SearchResult = ReusableMethods_Logger.captureTextMethod(driver,"//*[@id='result-stats']",logger,"search result");
        String[] Result = SearchResult.split(" ");
        System.out.println("Search number is: " + Result[1]);
    }//end of test 2

    @AfterSuite
    public void writeBackToReport(){
        //end the logger for tests
        reports.endTest(logger);
        reports.flush();
    }//end of after suite

}//end of class
