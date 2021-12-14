package com.bestbuy.adeng.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdPage {
    public static WebDriver driver = null;

    public static WebDriverWait wait = null;

    /**
     * Initialize the Adpage with driver
     *
     * @param driver
     */
    AdPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    /**
     * Apply wait till it is visible for component
     *
     * @param b
     * @return
     */
    public static WebElement waitTillVisible(By b) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(b));
    }

    /**
     * Set text into a text box
     *
     * @param b
     * @param text
     */
    public static void setText(WebElement b, String text) {

        wait.until(ExpectedConditions.visibilityOf(b)).sendKeys(text);
    }

    /**
     * How to click the element
     *
     * @param b
     */
    public static void clickEle(By b) {
        waitTillVisible(b).click();

    }
    public static void clickEle(WebElement  b) {
       wait.until(ExpectedConditions.visibilityOf(b)).click();

    }

    /**
     * Get the Dimension for the Web Element
     *
     * @param b
     * @return
     */
    public static Dimension getDimension(WebElement b) {
        return wait.until(ExpectedConditions.visibilityOf(b)).getSize();

    }
    public static void scrollToTop(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,0)", "");
    }
    public static void scrollUp(){
     Actions a = new Actions(driver);
     a.sendKeys(Keys.HOME).build().perform();


    }
    /**
     * This method scrolls screen by 250
     */
    public static void scrollScreen() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

    }
    public static void scrollScreen2000() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");

    }
    public static void scrollScreenback() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1000)", "");

    }
    public static void scrollScreenUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)", "");

    }
    public static void scrollBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,7000) ","");

    }

}
