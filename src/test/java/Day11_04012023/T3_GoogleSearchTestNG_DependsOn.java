package Day11_04012023;

import ReusableLibrary.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T3_GoogleSearchTestNG_DependsOn {
    //to make a variable global, you must declare it outside of the annotation methods
    WebDriver driver;

    //create before suit method to define your chrome driver
    @BeforeSuite
    public void setupDriver() throws InterruptedException {
        driver = ReusableMethods.defineChromeDriver();
    }//end of before suit

    //@Test is a replacement of the main method to execute your code
    @Test(priority = 1)//priority only to execute which one gets executed first
    public void searchForBmw() {
        //navigate to google home
        driver.navigate().to("https://www.google.com");
        //enter bmw on search field
        ReusableMethods.sendKeysMethod(driver, "//*[@name='q']", "BMW", "Search Field");
        //submit the Google search
        ReusableMethods.submitMethod(driver, "//*[@name='btnK']", "Google Search");
    }//end of test 1

    @Test(dependsOnMethods = "searchForBmw")//depends on used if a test depends on another test. use double quotes for the test
    public void captureSearchNumberForBmw(){
        //capture the text and print out the number
        String result = ReusableMethods.captureTextMethod(driver, "//*[@id='result-stats']","Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("Search number for BMW: " + arrayResult[1]);
    }//end of test 2

    @Test(dependsOnMethods = {"searchForBmw","captureSearchNumberForBmw"})//must include all the dependencies or the test will fail
    public void clickOnFinance() {
        ReusableMethods.clickMethod(driver,"//div[text()='Finance']","Finance");
    }//end of test 3


    //Quit the driver
    @AfterSuite
    public void quitSession(){
        driver.quit();
    }
}//end of class
