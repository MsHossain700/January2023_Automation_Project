package Day5_03112023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T3_ChromeOptions {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();

        //add maximize for windows
        options.addArguments("start-maximized");

        //always add 2-3 seconds of delay
        Thread.sleep(3000);

        //add incognito mode to option
        options.addArguments("incognito");

        //add options to run your driver on the background(headless)
        //options.addArguments("headless");

        //define the chrome driver that you will use for automation test
        //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");

        //always add 2-3 seconds of delay
        Thread.sleep(3000);

        //click on mail link
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

        //always add 2-3 seconds of delay
        Thread.sleep(3000);

        //print out sign in to yahoo text
        String result =  driver.findElement(By.xpath("//*[contains(text(),'Sign')]")).getText();
        System.out.println("Result: " + result);

        driver.quit();


    }//end of main
}//end of class
