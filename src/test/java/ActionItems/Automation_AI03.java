package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Automation_AI03 {
    public static void main(String[] args) throws InterruptedException {

        //Create an ArrayList containing 3 real zipCode
        ArrayList <Integer> zipCode = new ArrayList<>();
        zipCode.add(11432);
        zipCode.add(11434);
        zipCode.add(11549);

        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();

        //add maximize for windows
        options.addArguments("start-maximized");

        //always add 2-3 seconds of delay
        Thread.sleep(2000);

        //add incognito mode to option
        options.addArguments("incognito");

        //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        for(int i = 0; i < zipCode.size(); i++) {

            //navigate to www.weightwatchers.com/us/find-a-workshop/
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

            //always add 2-3 seconds of delay
            Thread.sleep(2000);

            //click on find a workshop link
            driver.findElement(By.xpath("//*[@id='__next']")).click();
            Thread.sleep(2000);

            //click on in person link
            driver.findElement(By.xpath("//*[@id=\"search-container\"]/div[1]/div[1]/button/div/span")).click();
            Thread.sleep(2000);

            //clear the zipcode field
            WebElement ZipcodeField = driver.findElement(By.xpath("//*[@class='input input-3TfT5']"));
            ZipcodeField.clear();
            //send the real ziCodes to zipcode field
            ZipcodeField.sendKeys(zipCode.get(i).toString());

            //click submit
            driver.findElement(By.xpath("//*[@class='ww button primary cta-1JqRp']")).click();
            Thread.sleep(2000);

            //click on the specific studios
            ArrayList<WebElement> studios = (ArrayList<WebElement>) driver.findElements(By.xpath("//a[contains(text(),'WW Studio')]"));

            if (i == 0) {
                studios.get(1).click();
            } else if (i == 1) {
                studios.get(2).click();
            } else if (i == 2) {
                studios.get(0).click();
            }//end of conditional statement

            Thread.sleep(2000);




            /*scroll in to the calculate button and set that as the initial point of page
            WebElement schedule = driver.findElement(By.xpath("//*[@class='title-bEfSM']"));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true)",schedule);

            */


        }//end of loop

    }//end of main
}//end of class

