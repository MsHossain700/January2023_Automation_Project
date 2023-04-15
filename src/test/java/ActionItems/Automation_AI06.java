package ActionItems;

import ReusableLibrary.ReusableAnnotations;
import ReusableLibrary.ReusableMethods;
import org.testng.annotations.Test;

public class Automation_AI06 extends ReusableAnnotations {

    @Test(priority = 1)
    public void fidelisCareTestCase_1(){
        //navigate to https://www.fideliscare.org/
        driver.navigate().to("https://www.fideliscare.org/");
        //click on search element
        ReusableMethods.clickMethod(driver, "//*[@class='tool dropdown search']", "Search element");
        //enter dental coverage on the search
        ReusableMethods.sendKeysMethod(driver, "//*[@class='form-control search-input']","get dental coverage","Search field");
        //click on search icon
        ReusableMethods.clickMethod(driver, "//*[@class='btn btn-primary btn-search']","Search icon");
        //capture the search result
        String SearchResult = ReusableMethods.captureTextMethod(driver, "//*[@id='resInfo-0']","Search result");
        //splitting the result
        String[] Result = SearchResult.split(" ");
        //print only the search number
        System.out.println("Search number is " + Result[1]);
        //click on get dental coverage link
        ReusableMethods.clickMethod(driver,"//*[@id='___gcse_0']/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/div/a","Get dental coverage link");

    }//end of test 1

    @Test(dependsOnMethods = "fidelisCareTestCase_1")
        public void fidelisCareTestCase_2(){
        //Switch to new tab
        ReusableMethods.switchToTabByIndex(driver, 1);
        //Enter first name
        ReusableMethods.sendKeysMethod(driver, "//*[@id='firstName']", "John", "First name field");
        //Enter last name
        ReusableMethods.sendKeysMethod(driver, "//*[@id='lastName']", "Doe", "Last name field");
        //Enter Zip code
        ReusableMethods.sendKeysMethod(driver, "//*[@id='zipCode']", "11432","Zip code field");
        //Select county
        ReusableMethods.selectByText(driver, "//*[@id='county']", "Queens", "County list");
        //Enter phone number
        ReusableMethods.sendKeysMethod(driver, "//*[@id='phoneNumber']", "(929)498-4489","Phone number field");
        //Enter email
        ReusableMethods.sendKeysMethod(driver, "//*[@id='email']", "JDoe@mail.com","email field");
        //Click on the checkbox for contact me
        ReusableMethods.clickMethod(driver, "//*[@id='dnn_ctr12145_ModuleContent']/cm-root/cm-form/div/form/div/div[7]/div/label","CONTACT ME check box");
        //click on contact me
        ReusableMethods.clickMethod(driver, "//*[@id='dnn_ctr12145_ModuleContent']/cm-root/cm-form/div/form/div/div[8]/button","CONTACT ME button");
        //Capture the "Thank you for your submission" message
        String message_1 = ReusableMethods.captureTextMethod(driver,"//*[@class='alert alert-success']","'Thank you for your submission' message");
        //Print out the "Thank you for your submission" message
        System.out.println(message_1);
        driver.close();

    }//end of Test 2

    @Test(dependsOnMethods = {"fidelisCareTestCase_1", "fidelisCareTestCase_2"})
        public void fidelisCareTestCase_3(){
        //Switch back to default tab
        ReusableMethods.switchToTabByIndex(driver, 0);
        //Click on login
        ReusableMethods.clickMethod(driver, "//*[@class='tool dropdown login']","login");
        //click on "Member Online Portal"
        ReusableMethods.clickMethod(driver, "//*[@id='header']/div[2]/div[3]/ul/li[1]/a","Member Online Portal");
        //Switch to new tab
        ReusableMethods.switchToTabByIndex(driver, 1);
        //Capture and print out Helpful Hints to the right
        String message_2 = ReusableMethods.captureTextMethod(driver, "//*[@id='TipsPanel']","Helpful Hints");
        System.out.println(message_2);
        driver.close();

    }//end of Test 3



}//end of class
