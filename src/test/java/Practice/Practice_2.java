package Practice;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practice_2 {
    public static void main(String[] args) throws InterruptedException {

        //Create an ArrayList containing 3 real zipCode
        ArrayList <Integer> zipCode = new ArrayList<>();
        zipCode.add(78572);
        zipCode.add(38128);
        zipCode.add(36605);

        for(int i = 0; i < zipCode.size(); i++) {

            //set up your driver through web driver manager
            WebDriverManager.chromedriver().setup();

            //set your chrome options arguments for your web driver
            ChromeOptions options = new ChromeOptions();

            //add maximize for windows
            options.addArguments("start-maximized");

            //add incognito mode to option
            options.addArguments("incognito");

            //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
            WebDriver driver = new ChromeDriver(options);

            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

            //always add 2-3 seconds of delay
            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@id='__next']")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@id=\"search-container\"]/div[1]/div[1]/button/div/span")).click();
            Thread.sleep(2000);

            WebElement ZipcodeField = driver.findElement(By.xpath("//*[@class='input input-3TfT5']"));
            ZipcodeField.clear();
            Thread.sleep(2000);

            ZipcodeField.sendKeys(zipCode.get(i).toString());

            driver.findElement(By.xpath("//*[@class='ww button primary cta-1JqRp']")).click();
            Thread.sleep(2000);

            ArrayList<WebElement> studios = (ArrayList<WebElement>) driver.findElements(By.xpath("//a[contains(text(),'WW Studio')]"));

            if (i == 0) {
                studios.get(1).click();
            } else if (i == 1) {
                studios.get(2).click();
            } else if (i == 2) {
                studios.get(0).click();
            }
            Thread.sleep(2000);

            //capture entire address
            WebElement address = driver.findElement(By.xpath("//div[@class='location__container']/div[1]"));
            String fullAddress = address.getText();
            System.out.println("Address: " + fullAddress);

            //scroll into the Studio Workshops schedule (in-person) element using JavascriptExecutor
            WebElement schedule = driver.findElement(By.xpath("//h3[contains(text(),'Studio Workshops schedule (in-person)')]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", schedule);

            Thread.sleep(2000);

            //capture entire table with days and hours for the virtual studio
            WebElement table = driver.findElement(By.xpath("//div[contains(@class,'schedule-detailed__schedule-table-wrapper')]/table"));
            String scheduleTable = table.getText();
            System.out.println("Schedule Table: \n" + scheduleTable);

            driver.quit();
            }//end of loop

        }//end of main
    }//end of class
