package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Automation_AI04 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        Thread.sleep(1000);

        //creating an ArrayList for state destinations
        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("Colorado");
        destinations.add("New York");
        destinations.add("California");

        //creating an ArrayList for adult traveler count
        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(2);
        adults.add(3);
        adults.add(4);

        //creating an ArrayList for child traveler age
        ArrayList<String> child = new ArrayList<>();
        child.add("Under 1");
        child.add("1");
        child.add("2");

        //creating a for loop to navigate to hotels.com, choose destination and traveler count
        for (int i = 0; i < destinations.size(); i++) {

            //navigating to hotels.com
            driver.navigate().to("https://www.hotels.com");

            Thread.sleep(2000);

            //creating a WebElement for the first search box xpath
            WebElement destCountry = driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']"));

            //creating a try/catch to select the first search box
            try {
                destCountry.click();
                Thread.sleep(1000);
                System.out.println("Successfully clicked on Going to");
            } catch (Exception a) {
                System.out.println("Unable to enter to click on Going to " + a);
            }//end of exception

            //creating a WebElement for the first search box
            WebElement destCountry2 = driver.findElement(By.xpath("//*[@class='uitk-field-input uitk-typeahead-input uitk-typeahead-input-v2']"));

            //creating a try/catch for sending the states into the first serach box
            try {
                destCountry2.sendKeys(destinations.get(i));
                System.out.println("Successfully sent states into search box");
            } catch (Exception b) {
                System.out.println("Unable to sendkeys for states" + b);
            }//end of exception

            Thread.sleep(1000);

            //creating a try/catch for clicking on the first result
            try {
                driver.findElement(By.xpath("//*[@data-stid='destination_form_field-result-item']")).click();
                System.out.println("Successfully clicked on first search");
            } catch (Exception c) {
                System.out.println("Unable to click on dropdown " + c);
            }//end of exception

            Thread.sleep(1000);

            //creating a WebElement to select on the Travelers search box
            WebElement travelerCount = driver.findElement(By.xpath("//*[@data-stid='open-room-picker']"));

            //creating a Try/Catch for clicking on the Travelers search box
            try {
                travelerCount.click();
                System.out.println("Successfully clicked on travelers");
            } catch (Exception d) {
                System.out.println("Unable to click on travelers" + d);
            }//end of exception

            Thread.sleep(1000);

            //creating a WebElement for the decrease adult age by 1 button
            WebElement decreaseAdultTravelerCount = driver.findElement(By.xpath("//*[@aria-label='Decrease the number of adults in room 1']"));

            //creating a Try/Catch for decreasing adult age by 1
            try {
                decreaseAdultTravelerCount.click();
                System.out.println("Successfully decreased adult age by 1");
            } catch (Exception e) {
                System.out.println("Unable to decrease adult age by 1" + e);
            }//end of exception

            Thread.sleep(2000);

            //creating a WebElement for the increase child age by 1 button
            WebElement increaseChildrenTravelerCount = driver.findElement(By.xpath("//*[@aria-label='Increase the number of children in room 1']"));

            //creating a Try/Catch for increasing child age by 1
            try {
                increaseChildrenTravelerCount.click();
                System.out.println("Successfully increased children age by 1");
            } catch (Exception f) {
                System.out.println("Unable to increase children age by 1" + f);
            }//end of exception

            //creating a WebElement for the increase adult age by 1 button
            WebElement increaseTravelerCount = driver.findElement(By.xpath("//*[@aria-label='Increase the number of adults in room 1']"));

            //creating a for loop to increase adult age to the adults ArrayList for each iteration
            for (int j = 0; j < adults.get(i); j++) {

                //creating a Try/Catch for increasing adult age by 1
                try {
                    increaseTravelerCount.click();
                    Thread.sleep(1000);
                    System.out.println("Successfully increased adult age");
                } catch (Exception g) {
                    System.out.println("Unable to increase adult age" + g);
                }//end of exception

            }//end of sub for loop for increasing adult age

            //creating a WebElement for the child age dropdown
            WebElement childAge = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));

            //selecting the age from the dropdown menu
            for (int c = 0; c < child.size(); c++) {
                Select childAgeDropDown = new Select(childAge);
                childAgeDropDown.selectByVisibleText("Under 1");
            }

            Thread.sleep(1000);

            //creating a Try/Catch for clicking on a search button
            try {
                driver.findElement(By.xpath("//*[@id='search_button']")).click();
                System.out.println("Successfully clicked on the search button");
            } catch (Exception h) {
                System.out.println("Unable to click on search button" + h);
            }

            Thread.sleep(5000);

            //creating a ArrayList to store links as a WebElement
            ArrayList<WebElement> hotels = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid='open-hotel-information']")));

            //creating an if/else if statement to click the correct links according to the for loop count
            if (i == 0) {
                hotels.get(0).click();
            } else if (i == 1) {
                hotels.get(2).click();
            } else if (i == 2) {
                hotels.get(1).click();
            }

            //capturing tabs as an array list
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            //switching to second tab
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(3000);

            //creating a Try/Catch for retrieving the hotel name
            try {
                String hotelName = driver.findElement(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).getText();
                System.out.println("This resorts name is " + hotelName);
            } catch (Exception ii) {
                System.out.println("Unable to retrieve the hotel name" + ii);
            }

            Thread.sleep(3000);

            //creating a Try/Catch for clicking on the Reserve a Room button
            try {
                driver.findElement(By.xpath("//*[@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-primary']")).click();
                System.out.println("Successfully clicked on Reserve a Room");
            } catch (Exception j) {
                System.out.println("Unable to click on Reserve a Room" + j);
            }

            Thread.sleep(1000);

            //creating a Try/Catch for retrieving the price per night for the hotel
            try {
                String hotelNightlyCost = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(1).getText();
                System.out.println("The price per night for this hotel is " + hotelNightlyCost);
            } catch (Exception k) {
                System.out.println("Unable to retrieve the price per night for the hotel" + k);
            }

            Thread.sleep(1000);

            //creating a Try/Catch for clicking on the Reserve button
            try {
                driver.findElements(By.xpath("//*[@class='uitk-button uitk-button-medium uitk-button-primary']")).get(0).click();
                System.out.println("Successfully clicked on the Reserve button");
            } catch (Exception l) {
                System.out.println("Unable to click on the Reserve button" + l);
            }

            Thread.sleep(3000);

            //creating a Try/Catch for clicking on the Pay Now button
            try {
                driver.findElements(By.xpath("//*[@class='uitk-button uitk-button-medium uitk-button-primary']")).get(7).click();
                System.out.println("Successfully clicked on the Pay Now button");
            } catch (Exception m) {
                System.out.println("Unable to click on the Pay Now button" + m);
            }

            Thread.sleep(1000);

            //creating a Try/Catch for retrieving the check-in date
            try {
                String checkInDate = driver.findElement(By.xpath("//*[@class='col-value va-t ta-r pv-tiny travel-dates-check-in fw-bold']")).getText();
                System.out.println("The check-in date is " + checkInDate);
            } catch (Exception n) {
                System.out.println("Unable to retrieve the check-in date" + n);
            }

            Thread.sleep(1000);

            //creating a Try/Catch for retrieving the check-out date
            try {
                String checkOutDate = driver.findElement(By.xpath("//*[@class='col-value va-t ta-r pv-tiny travel-dates-check-out fw-bold']")).getText();
                System.out.println("The check-out date is " + checkOutDate);
            } catch (Exception o) {
                System.out.println("Unable to retrieve the check-out date" + o);
            }

            Thread.sleep(1000);

            //closing the tab
            driver.close();

            Thread.sleep(1000);

            //switching back to the first tab
            driver.switchTo().window(tabs.get(0));

        }//end of main for loop

        driver.quit();
    }//end of main
}//end of class
