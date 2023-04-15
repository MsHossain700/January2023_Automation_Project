package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class practice_3 {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> topics = new ArrayList<>();
        topics.add("Rust");
        topics.add("Top Gear");
        topics.add("top gun 2");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        WebDriver driver = new ChromeDriver(options);
        Thread.sleep(2000);

        for (int i = 0; i < topics.size(); i++) {
            driver.navigate().to("https://www.google.com/");
            Thread.sleep(2000);
            WebElement searchField = driver.findElement(By.xpath("//*[@name='q']"));

            try {
                searchField.click();
                System.out.println("Successfully clicked on search bar");
            }catch (Exception a){
                System.out.println("Unable to click on searchField" + a);
            }//end of exception

            Thread.sleep(2000);

            try {
                searchField.sendKeys(topics.get(i));
                System.out.println("Successfully sent topics to search bar");
            }catch (Exception b){
                System.out.println("Unable to send topics to search bar" + b);
            }//end of exception

            Thread.sleep(2000);

            WebElement submit = driver.findElement(By.xpath("//*[@name='btnK']"));
            try {
                submit.click();
                System.out.println("Successfully clicked submit");
            }catch (Exception c){
                System.out.println("Unable to click on submit" + c);
            }//end of exception

            String firstResultDescription = driver.findElement(By.xpath("//*[@class='VwiC3b yXK7lf MUxGbd yDYNvb lyLwlc lEBKkf']")).getText();
                    Thread.sleep(2000);
            System.out.println(firstResultDescription);



        }//end of for loop

    }//end of main
}//end of class
