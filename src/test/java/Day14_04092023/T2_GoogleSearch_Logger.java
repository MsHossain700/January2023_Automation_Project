package Day14_04092023;

import ReusableLibrary.ReusableAnnotations;
import ReusableLibrary.ReusableMethods_Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class T2_GoogleSearch_Logger extends ReusableAnnotations{

        @Test(priority = 1)
        public void searchForCricket(){
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
            //capture the search result
            String SearchResult = ReusableMethods_Logger.captureTextMethod(driver,"//*[@id='result-stats']",logger,"search result");
            String[] Result = SearchResult.split(" ");
            System.out.println("Search number is: " + Result[1]);
        }//end of test 2

}//end of class



