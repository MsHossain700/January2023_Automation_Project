package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("hot wheels");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        Thread.sleep(2000);
        String result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String[] arrayMessage = result.split(" ");
        System.out.println(arrayMessage[3]);
        driver.close();

    }
}
