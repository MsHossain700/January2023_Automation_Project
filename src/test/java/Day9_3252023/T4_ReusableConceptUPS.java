package Day9_3252023;

import ReusableLibrary.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T4_ReusableConceptUPS {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= ReusableMethods.defineChromeDriver();

        //navigate to ups website
        driver.navigate().to("http://www.ups.com/us");

        //declare the explicit wait command
        WebDriverWait wait = new WebDriverWait(driver,20);

        //click on shipping
        //your explicit wait condition replaces your driver.findElement(s)
        //presenceOfAllElementsLocatedBy is same as findElements
        ReusableMethods.clickMethod(driver,"//*[@id='mainNavDropdown1']","Shipping Link");

        //click on Schedule a Pickup
        //when you see element not interactable exception then you have to use Thread.sleep for few seconds before
        Thread.sleep(2000);
        ReusableMethods.clickMethod(driver,"//*[text()='Schedule a Pickup']","Schedule a Pickup");

        //click on Freight
        ReusableMethods.clickMethod(driver,"//*[text()='Freight']","Freight");





    }//end of main
}//end of class
