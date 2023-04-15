package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Practice_4 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> topics = new ArrayList<>();
        topics.add("Rust");
        topics.add("Top Gear");
        topics.add("top gun 2");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        WebDriver driver = new ChromeDriver(options);


    }//end of main
}//end of class
