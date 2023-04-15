package ActionItems;

import ReusableLibrary.ReusableMethods;
import org.openqa.selenium.WebDriver;

public class Automation_AI05 {
    public static void main(String[] args) throws InterruptedException {
        //set up the chrome driver
        WebDriver driver = ReusableMethods.defineChromeDriver();

        //navigate to BestBuy home page
        driver.navigate().to("https://www.bestbuy.com");

        //enter keyWord in the search field
        ReusableMethods.sendKeysMethod(driver,"//*[@class='search-input']","iphone","Search Field");

        //click on the search icon next to the search field
        ReusableMethods.clickMethod(driver,"//*[@class='header-search-button']","Search Icon");

        //select "Best Selling"
        ReusableMethods.selectByText(driver, "//*[@id='sort-by-select']", "Best Selling", "Sort By");
        Thread.sleep(2000);

        //click on the first iphone
        ReusableMethods.clickByIndex(driver,"//*[@class='list-item  lv']",0,"First Iphone");

        //scroll to learn about totalTech
        ReusableMethods.scrollByElement(driver, "//*[@class='c-button c-button-outline c-button-md c-button-block v-m-top-xs']", "learn about totalTech");

        //click on add to cart
        ReusableMethods.clickMethod(driver,"//*[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button']","add to cart");

        //capture subtotal
        String result = ReusableMethods.captureTextMethod(driver,"//*[@class='shop-cart-subtotal']","subtotal");
        String[] parts = result.split(":");
        String subtotal = parts[1].trim();
        System.out.println(subtotal);

        //hover over continue shopping
        ReusableMethods.mouseHover(driver,"//*[@class='c-button-link continue-shopping']","Continue shopping");

        //click on Continue shopping
        ReusableMethods.clickMethod(driver,"//*[@class='c-button-link continue-shopping']","Continue shopping");



    }//end of main
}//end of class
