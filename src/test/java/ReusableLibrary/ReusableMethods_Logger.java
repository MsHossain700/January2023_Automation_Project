package ReusableLibrary;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class ReusableMethods_Logger {
    //submit action is one of the type of void method
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
    public static void clickMethod(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            System.out.println("Successfully clicked on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }//end of exception
    }//end of click method

    //click action is one of the type of void method
    public static void clickByIndex(WebDriver driver,String xpath,int index,ExtentTest logger,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            System.out.println("Successfully clicked on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }//end of exception
    }//end of click method by index


    //selectByText Method
    public static void selectByText(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userValue);
            System.out.println("Successfully selected element: " + elementName);
            logger.log(LogStatus.PASS,"Successfully selected element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select dropDown: " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to select dropDown: " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }//end of exception
    }//end of selectByText reusableMethod


    //scrollByElement Method
    public static void scrollByElement(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView();", element);
            System.out.println("Successfully scrolled to element: " + elementName);
            logger.log(LogStatus.PASS,"Successfully scrolled to element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll to element: " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to scroll to element: " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }//end of exception
    }//end of scrollByElement Method


    //mouseHover Method
    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            System.out.println("Successfully hovered over element: " + elementName);
            logger.log(LogStatus.PASS,"Successfully hovered over element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover over element: " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to hover over element: " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }//end of exception
    }// end of mouseHover Method


    //Boolean Method
    public static void verifyBooleanStatement(WebDriver driver, String xpath, boolean expectedValue, ExtentTest logger, String elementName) {
        //store the xpath in boolean statement
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
            System.out.println("Value: " + elementState);
            if (elementState == expectedValue) {
                System.out.println("Passed: Checkbox is " + expectedValue);
                logger.log(LogStatus.PASS,"Passed: Checkbox is " + expectedValue);
            } else {
                System.out.println("Failed: Checkbox is " + elementState);
                logger.log(LogStatus.FAIL, "Failed: Checkbox is " + elementState);
            }
        } catch (Exception e) {
            System.out.println("Unable to verify element:  " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to verify element:  " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
        }//end of exception
    }//end of verifyBooleanStatement


    //switchToTabByIndex Method
    public static void switchToTabByIndex(WebDriver driver, ExtentTest logger, int tabIndex) {
        try {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabIndex));
            System.out.println("Switched to tab with index: " + tabIndex);
            logger.log(LogStatus.PASS, "Switched to tab with index: " + tabIndex);
        } catch (Exception e) {
            System.out.println("Unable to switch to tab with index: " + tabIndex + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to switch to tab with index: " + tabIndex + ": " + e);
        }//end of exception
    }//end of switchToTabByIndex
    // to call it use ReusableMethods.switchToTabByIndex(driver, tabIndex);


    //scrollByPixel Method
    public static void scrollByPixel(WebDriver driver, ExtentTest logger, int pixel) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            jse.executeScript("window.scrollBy(0," + pixel + ")");
            System.out.println("Scrolled by " + pixel + " pixels.");
            logger.log(LogStatus.PASS, "Scrolled by " + pixel + " pixels.");
        } catch (Exception e) {
            System.out.println("Unable to scroll by: " + pixel + " pixels: " + e);
            logger.log(LogStatus.FAIL, "Unable to scroll by: " + pixel + " pixels: " + e);
        }//end of exception
    }//end of scrollByPixel Method
    //to call it use ReusableMethods.scrollByPixel(driver, 500);


    public static void submitMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            System.out.println("Successfully submit on element " + elementName);
            logger.log(LogStatus.PASS, "Successfully submit on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to submit on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }//end of exception
    }//end of submit method


    //sendKeys action is one of the type of void method
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on element " + elementName);
            logger.log(LogStatus.PASS, "Successfully entered a value on element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on element: " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to enter a value on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }//end of exception
    }//end of sendKeys method


    //capture a text and return it using return method
    public static String captureTextMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            System.out.println("Successfully captured a text from element " + elementName);
            logger.log(LogStatus.PASS, "Successfully captured a text from element: " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text from element: " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to capture text from element: " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }//end of exception
        return result;
    }// end of captureTextMethod


    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,String imageName,ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!! " + e);
        }
    }//end of getScreenshot method



}//end of class


