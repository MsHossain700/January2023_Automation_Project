package Day5_03112023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Xpath_Text {
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
        driver.navigate().to("https://www.google.com");

        //always add a 2-3 seconds of delay
        Thread.sleep(2000);

        //click on About text link using xpath text()=
        driver.findElement(By.xpath("//*[text()='About']")).click();


    }//end of main
}//end of class
