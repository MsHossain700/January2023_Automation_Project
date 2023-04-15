package Day9_3252023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T3_ExplicitWait {
    public static void main(String[] args) throws InterruptedException {

        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        //navigate to ups website
        driver.navigate().to("http://www.ups.com/us");

        //declare the explicit wait command
        WebDriverWait wait = new WebDriverWait(driver,20);

        //click on shipping
        //your explicit wait condition replaces your driver.findElement(s)
        //presenceOfAllElementsLocated = driver.findElements
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='mainNavDropdown1']"))).click();

        //click on Schedule a Pickup
        //when you see element not interactable exception then you have to use Thread.sleep for few seconds before
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Schedule a Pickup']"))).click();

        //enter a tracking number on the box
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='tracknumlist']"))).sendKeys("1234455555");

    }//end of main
}//end of class
