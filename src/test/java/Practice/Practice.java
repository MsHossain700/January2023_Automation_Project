package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
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

        //click on About text link using xpath text()
        driver.findElement(By.xpath("//*[text()='About']")).click();

        //capture the header in "About page"
        String result1 = driver.findElement(By.xpath("//*[@class='modules-lib__mission-statement__headline glue-headline glue-headline--fluid-2']")).getText();
        //driver.quit();
        System.out.println(result1);

        Thread.sleep(2000);
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='_yb_1ijba   rapid-noclick-resp']")).click();





    }//end main
}//end of class
