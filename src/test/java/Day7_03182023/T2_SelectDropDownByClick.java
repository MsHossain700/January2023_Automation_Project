package Day7_03182023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T2_SelectDropDownByClick {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();

        //add maximize for windows
        options.addArguments("start-maximized");

        //always add 2-3 seconds of delay
        Thread.sleep(2000);

        //add incognito mode to option
        options.addArguments("incognito");

        //define the chrome driver that you will use for automation test
        //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator site
        driver.navigate().to("https://www.mortgagecalculator.org");

        Thread.sleep(2000);

        //select start month as April from the dropdown using select function
        //store the start month locator as an WebElement
        driver.findElement(By.xpath("//*[@name='param[start_month]']")).click();
        Thread.sleep(2000);

        //click on the dropdown value by using xpath text
        driver.findElement(By.xpath("//*[text()='Apr']")).click();

        driver.findElement(By.xpath("//*[@class='content-area']")).click();

        Thread.sleep(2000);
        driver.quit();


    }//end of main
}//end of class
