package ActionItems;

import ReusableLibrary.ReusableAnnotations;
import ReusableLibrary.ReusableMethods;
import ReusableLibrary.ReusableMethods_Logger;
import org.testng.annotations.Test;

public class Automation_AI07 extends ReusableAnnotations {
    @Test(priority = 1)
    public void nikeTestCase() throws InterruptedException {
        //navigate to Nike US home page
        driver.navigate().to("https://www.nike.com/");
        //click on search field
        ReusableMethods_Logger.clickMethod(driver,"//input[@id='VisualSearchInput']",logger,"Search field");
        //Search for Mercurial SuperFly
        ReusableMethods_Logger.sendKeysMethod(driver,"//input[@id='VisualSearchInput']","Zoom Mercurial Superfly 9",logger,"Search field");
        //submit
        ReusableMethods_Logger.clickMethod(driver,"//button[@class='pre-search-btn ripple']",logger,"submit");
        Thread.sleep(2000);
        //scroll down to Zoom Mercurial SuperFly 9
        ReusableMethods_Logger.scrollByPixel(driver, logger, 800);
        //select Zoom Mercurial SuperFly 9
        ReusableMethods_Logger.clickMethod(driver, "//*[@id='skip-to-products']/div[5]/div/figure/a[2]/div/img",logger,"Zoom Mercurial Superfly 9");
        //select color
        ReusableMethods_Logger.clickMethod(driver,"//img[@alt='White/Pink Blast/Indigo Haze/Baltic Blue']",logger,"color");
        //select size
        ReusableMethods_Logger.clickMethod(driver, "//*[@id='buyTools']/div[1]/fieldset/div/div[10]/label",logger,"size");
        //capture the price
        String message = ReusableMethods_Logger.captureTextMethod(driver,"//*[@id='RightRail']/div/div[1]/div/div[2]/div/div/div/div/div",logger,"price");
        //print the price
        System.out.println("The price is " + message);
    }//end of Test 1

    @Test(priority = 2)
    public void amazonTestCase() {
        //navigate to amazon home
        driver.navigate().to("https://www.amazon.com/");
        //click on the search box
        ReusableMethods_Logger.clickMethod(driver,"//input[@id='twotabsearchtextbox']",logger,"search box");
        //Search for Hot Wheels
        ReusableMethods_Logger.sendKeysMethod(driver,"//input[@id='twotabsearchtextbox']","hot wheels pagani zonda r",logger,"search box");
        //submit
        ReusableMethods_Logger.clickMethod(driver,"//input[@id='nav-search-submit-button']",logger,"submit");
        //select
        ReusableMethods_Logger.clickMethod(driver,"//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div[1]/span/a/div/img",logger,"First result");
        //add to cart
        ReusableMethods_Logger.clickMethod(driver,"//input[@id='add-to-cart-button']",logger,"add to cart");
        //click on proceed to checkout
        ReusableMethods_Logger.clickMethod(driver,"//input[@name='proceedToRetailCheckout']",logger,"proceed to checkout");
    }//end of Test 2

    @Test(priority = 3)
    public void geicoRepairXpress() {
        //navigate to geico claims
        driver.navigate().to("https://www.geico.com/claims/");
        //click on "learn about claims process"
        ReusableMethods_Logger.clickMethod(driver,"//*[@id='claims-resources-options']/ul/li[1]/a",logger,"learn about claims process");
        //click on "How GEICO Handles Your Claim"
        ReusableMethods_Logger.clickMethod(driver,"//*[@id='HowGEICOHandlesYourClaim']/h2/a",logger,"How GEICO Handles Your Claim");
        //scroll to "GEICO Auto Repair Xpress"
        ReusableMethods_Logger.scrollByPixel(driver,logger,500);
        //click on "GEICO Auto Repair Xpress"
        ReusableMethods_Logger.clickMethod(driver,"//*[@id='content']/p[6]/a[1]",logger,"GEICO Auto Repair Xpress");
    }//end of Test 3

    @Test(priority = 4)
    public void Formula1Ticket() throws InterruptedException {
        //navigate to Formula 1 home page
        driver.navigate().to("https://www.formula1.com/");
        //click on accept all
        ReusableMethods_Logger.clickMethod(driver,"//button[@id='truste-consent-button']",logger,"accept all");
        //click on tickets
        ReusableMethods_Logger.clickMethod(driver,"//*[@id='globalNav']/div/div[2]/div[2]/ul/li[4]/a",logger,"tickets");
        //switch to the new tab
        ReusableMethods.switchToTabByIndex(driver, 1);
        Thread.sleep(3000);
        //click accept all
        ReusableMethods_Logger.clickMethod(driver,"//button[@id='onetrust-accept-btn-handler']",logger,"accept all");
        //scroll to Mexico GP
        ReusableMethods_Logger.scrollByPixel(driver,logger,1500);
        Thread.sleep(3000);
        //Hover on Mexico GP
        ReusableMethods_Logger.mouseHover(driver,"//*[@id='calendar-content-wrapper']/div[2]/div/div[17]/div/div/div[1]/picture",logger,"Mexico GP");
        //click book now
        ReusableMethods_Logger.clickMethod(driver,"//*[@id='calendar-content-wrapper']/div[2]/div/div[17]/div/div/div[2]/div/a",logger,"Mexico GP");
        //scroll to Main Grandstand
        ReusableMethods_Logger.scrollByPixel(driver,logger,800);
        //select Main Grandstand
        ReusableMethods_Logger.clickMethod(driver,"//*[@id='10175']/div[2]/div[2]/a",logger,"Main Grandstand");
        //add 1 more ticket
        ReusableMethods_Logger.clickMethod(driver,"//span[@class='plus-caption']",logger,"add 1 more ticket");
        //click add to cart
        ReusableMethods_Logger.clickMethod(driver,"//button[@class='add-to-cart']",logger,"add to cart");
        //click close
        ReusableMethods_Logger.clickMethod(driver,"//span[@class='icon icon-close']",logger,"close");
        //click on shopping cart
        ReusableMethods_Logger.clickMethod(driver,"//*[@id='primaryNav']/div/div[3]/ul/li[3]/a/span",logger,"shopping cart");
        Thread.sleep(2000);
        String message2 = ReusableMethods_Logger.captureTextMethod(driver,"//div[@class='total-order-diff-currency-title']",logger,"total price");
        String[] Message3 = message2.split(":");
        System.out.println("Total price is" + Message3[1]);
    }//end of Test 4
//I added a new comment
}//end of class
