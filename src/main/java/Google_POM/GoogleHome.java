package Google_POM;

import ReusableLibrary.ReusableAnnotations;
import ReusableLibrary.ReusableMethods_LoggerPOM;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static ReusableLibrary.ReusableAnnotations.driver;

public class GoogleHome {
    //must declare a local logger variable to be used for each pom class
    ExtentTest logger;

    //constructor method is a helper method which creates a bridge between
    //your pom class and test class. Without constructor, you can't create a pom class
    public GoogleHome(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = ReusableAnnotations.logger;
    }//end of constructor

    //declare all the web elements you need from this page
    @FindBy(xpath = "//*[@name='q']")
    WebElement searchField;
    @FindBy(xpath = "//*[@name='btnK']")
    WebElement searchButton;
    //create your user defined method for each webElement
    public void enterKeywordOnSearchField(String userValue){
        ReusableMethods_LoggerPOM.sendKeysMethod(driver,searchField,userValue,logger,"Search Field");
    }//end of search method

    public void submitOnGoogleSearchButton(){
        ReusableMethods_LoggerPOM.submitMethod(driver,searchButton,logger,"Search Search Button");
    }//end of search button method


}//end of class


