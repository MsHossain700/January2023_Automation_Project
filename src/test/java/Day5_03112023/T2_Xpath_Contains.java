package Day5_03112023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_Xpath_Contains {
    public static void main(String[] args) throws InterruptedException {
        //set up driver through web driver manager
        WebDriverManager.chromedriver().setup();

        // define the web driver that you'll use
        WebDriver driver = new ChromeDriver();

        //maximize
        driver.manage().window().maximize();

        //always add a 2-3 seconds of delay
        Thread.sleep(2000);

        //navigate to google home
        driver.navigate().to("https://www.yahoo.com");

        Thread.sleep(2000);

        //using xpath contains click on the mail link by ignoring the white space on the text property for that element
        driver.findElement(By.xpath("//a[contains(text(),'Mail')]")).click();


    }// end of main
}//end of class
