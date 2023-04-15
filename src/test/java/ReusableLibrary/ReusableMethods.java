package ReusableLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;



public class ReusableMethods {
    //create a return method to return the webDriver you going to use on your test classes
    //static command allows your method to be global
    public static WebDriver defineChromeDriver() throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        Thread.sleep(2000);


        //define the chrome driver that you will use for automation test
        //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);


        return driver;
    }//end of webDriver method


    //return method will execute your statements along with returning some conditions/value
    //example of return methods are only WebDriver method & getText action

    //void method will only perform the action but won't return anything
    //void actions are click, sendKeys, scrolling, submit, select, mouse hover, clear


    //click action is one of the type of void method
    public static void clickMethod(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            System.out.println("Successfully clicked on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + ": " + e);
        }//end of exception
    }//end of click method


    //clickByIndex Method
    public static void clickByIndex(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            System.out.println("Successfully clicked on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + ": " + e);
        }//end of exception
    }//end of clickByIndex Method


    //click action is one of the type of void method
    public static void submitMethod(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            System.out.println("Successfully submit element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit element: " + elementName + ": " + e);
        }//end of exception
    }//end of click method


    //selectByText Method
    public static void selectByText (WebDriver driver, String xpath, String userValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userValue);
            System.out.println("Successfully selected element: " + elementName);
        }catch (Exception e){
            System.out.println("Unable to select dropDown: " + elementName + ": " + e);
        }//end of exception
    }//end of selectByText reusableMethod


    //scrollByElement Method
    public static void scrollByElement(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView();", element);
            System.out.println("Successfully scrolled to element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll to element: " + elementName + ": " + e);
        }//end of exception
    }//end of scrollByElement Method


    //mouseHover Method
    public static void mouseHover(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            System.out.println("Successfully hovered over element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover over element: " + elementName + ": " + e);
        }//end of exception
    }// end of mouseHover Method


    //sendKeys Method
    public static void sendKeysMethod(WebDriver driver,String xpath,String userValue,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered : " + userValue + " on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter: " + userValue + " on " + elementName + ": " + e);
        }//end of exception
    }//end of sendKeys method


    //capture a text and return it using return method
    public static String captureTextMethod(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        String result = "";
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            System.out.println("Successfully captured a text from element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text from element: " + elementName + ": " + e);
        }//end of exception
        return  result;//getText is a return method
    }//end of get text method


    //Boolean Method
    public static void verifyBooleanStatement(WebDriver driver, String xpath, boolean expectedValue, String elementName){
        //store the xpath in boolean statement
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
            System.out.println("Value: " + elementState);
            if (elementState == expectedValue) {
                System.out.println("Passed: Checkbox is " + expectedValue);
            } else {
                System.out.println("Failed: Checkbox is " + elementState);
            }
        } catch (Exception e) {
            System.out.println("Unable to verify element:  " + elementName + " " + e);
        }//end of exception
    }//end of verifyBooleanStatement


    //switchToTabByIndex Method
    public static void switchToTabByIndex(WebDriver driver, int tabIndex) {
        try {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabIndex));
            System.out.println("Switched to tab with index: " + tabIndex);
        } catch (Exception e) {
            System.out.println("Unable to switch to tab with index: " + tabIndex + ": " + e);
        }//end of exception
    }//end of switchToTabByIndex
    // to call it use ReusableMethods.switchToTabByIndex(driver, tabIndex);


    //scrollByPixel Method
    public  static void scrollByPixel(WebDriver driver, int pixel) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            jse.executeScript("window.scrollBy(0," + pixel + ")");
            System.out.println("Scrolled by " + pixel + " pixels.");
        } catch (Exception e) {
            System.out.println("Unable to scroll by: " + pixel + " pixels: " + e);
        }//end of exception
    }//end of scrollByPixel Method
    //to call it use ReusableMethods.scrollByPixel(driver, 500);


}//end of class
