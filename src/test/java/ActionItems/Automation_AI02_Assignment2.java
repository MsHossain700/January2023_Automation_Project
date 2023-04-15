package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Automation_AI02_Assignment2 {
    public static void main(String[] args) throws InterruptedException {

        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //define the chrome driver that you will use for automation test
        WebDriver driver = new ChromeDriver();

        //set up the ArrayList of hobbies
        ArrayList<String>hobby = new ArrayList<>();
        hobby.add("soccer");
        hobby.add("Formula 1");
        hobby.add("traveling");
        hobby.add("spelunking");


        for(int i=0; i<hobby.size(); i++){
            //navigate to bing.com
            driver.navigate().to("https://www.bing.com");

            //maximize the browser
            driver.manage().window().maximize();

            //wait for 2 seconds
            Thread.sleep(2000);

            //enter the hobby list in the search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobby.get(i));

            //click on search button
            driver.findElement(By.xpath("//*[@id='sb_form']")).submit();

            //wait for 2 seconds
            Thread.sleep(2000);

            //capture the search results using .getText()
            String result = driver.findElement(By.xpath("//*[@id='b_tween']/span[1]")).getText();

            //if the result contains use "if and else" statement
            //print out only the number
            String[] arrayResult = result.split(" ");
            System.out.println("For " + hobby.get(i) + " the search number is " + arrayResult[1]);

        }//end of loop

        //outside of loop is where you quit/close the driver
        driver.quit();


    }// end of main
}// end of class
