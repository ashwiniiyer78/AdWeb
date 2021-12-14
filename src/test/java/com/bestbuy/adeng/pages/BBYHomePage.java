package com.bestbuy.adeng.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

/**
 * This page has all the objects needed for the BBY Home page
 */
public class BBYHomePage extends AdPage {

    private static WebElement textfield = null;
    JavascriptExecutor js = null;

    private static By textf = null;


    public BBYHomePage(WebDriver driver) {

        super(driver);
        js = (JavascriptExecutor)driver;

    }

    private void setTextField(WebDriver driver) {
        textfield = AdPageObjects.searchTextBox;
    }


    public WebElement getTextField(WebDriver driver) {
        return driver.findElement(textf);
    }

    public WebElement getText() {
        return AdPageObjects.searchTextBox;

    }
    public void executeScriptFn(String script){
        js.executeScript(script);
    }
    public String getValueExecuteScript(String script){
        String str = js.executeScript(script).toString();
        return str ;
    }

    public void setTextFieldText(WebDriver d, String text) {

        setText(AdPageObjects.searchTextBox, text);

        clickEle(AdPageObjects.searchButton);

    }

    public Dimension get3SKUDim() {

        return getDimension(AdPageObjects.Ad3sku);


    }

    public Dimension getSponsoredDim() {
        return getDimension(AdPageObjects.sponsorDiv);
    }



    public static WebElement getSponsoredDiv() {
        return AdPageObjects.sponsorDiv;


    }

    public void closePopUP() {
        System.out.println("Ashw ::::"+AdPageObjects.pupup.getText());
        clickEle(AdPageObjects.pupup);

    }

    /**
     * Gets the Dimension of the Hero ad
     * @return
     */
    public Dimension getDimensionHeroAd(){
        return getDimension(AdPageObjects.heroAd);
    }
    public Dimension getRecEngineCarouselAd(){
        return getDimension(AdPageObjects.couroselDiv);
    }
    public void clickSVGMenu(){

        try{
        Thread.sleep(3000);}catch(Exception e ){}
//        js.executeScript("arguments[0].scrollIntoView();", AdPageObjects.buttomTop);
         clickEle(AdPageObjects.buttomTop);
         clickEle(AdPageObjects.buttonCat);
         clickEle(AdPageObjects.catBut);
         clickEle(AdPageObjects.category);

    }
    public void clickDepartment(){
          System.out.println(getDimension(AdPageObjects.deptSideKickAd));
    }
    public Dimension findSkyscraperAdSize(){

        clickEle(AdPageObjects.buttomTop);
        clickEle(AdPageObjects.buttonCat);
        clickEle(AdPageObjects.butoonVac);

        clickEle(AdPageObjects.uprightVaccum);
        scrollBottom();
        scrollScreenUp();
        return getDimension(AdPageObjects.skyscraperAd);
    }
    public static void goToRefrigeratorPage(){
        clickEle(AdPageObjects.buttomTop);
        clickEle(AdPageObjects.buttonCat);
        clickEle(AdPageObjects.majorKitApp);
        clickEle(AdPageObjects.regfrig);
    }
    public static boolean thoughtVisible(){
        WebElement thoughts = AdPageObjects.thoughtsSurvey;
        String text = thoughts.getText();
        thoughts.click();
        System.out.println("Thoughts text is "+text);
        return true;
    }
    public static void sendFeedback(){
        try{
            Thread.sleep(5000);}catch(Exception e ){e.printStackTrace();}

        try{
        Thread.sleep(3000);}catch(Exception e ){e.printStackTrace();}
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        String ChildWindow ="";
        String parent = iterator.next();
        while (iterator.hasNext()) {
            ChildWindow = iterator.next();
            System.out.println(ChildWindow);
        }
        driver.switchTo().window(ChildWindow);
        WebElement checkbox = driver.findElement(By.xpath("//input[@id = 'checkbox0']"));
        checkbox.click();
        WebElement checkbox1 = driver.findElement(By.id("checkbox3"));
        checkbox1.click();
        WebElement sbt_button = driver.findElement(By.id("submit_button"));
        sbt_button.click();
        try{
        Thread.sleep(5000);}catch(Exception e){}
        driver.close();
        driver.switchTo().window(parent);


    }
    public static void switchIFrame(String s){
        driver.switchTo().frame(s);
    }
    public static void switchIFrame(WebElement we ){
        driver.switchTo().frame(0);
    }
    public Dimension findDeptSideKickAdSize(){
        clickEle(AdPageObjects.buttomTop);
        clickEle(AdPageObjects.buttonCat);
        clickEle(AdPageObjects.majorKitApp);
        clickEle(AdPageObjects.regfrig);
        //scrollScreen2000();
        switchIFrame("google_ads_iframe_/6011/BestBuyDesktopWeb/appliances/refrigerators_1");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", AdPageObjects.depSideKick);
        System.out.println(AdPageObjects.depSideKick);
        return getDimension(AdPageObjects.depSideKick);
    }
    public Dimension findCategorySideKick(){
        scrollScreen2000();
        try{Thread.sleep(6000);}catch(Exception e ){}
        System.out.println("Iframe look out ");
         System.out.println("iframe is "+AdPageObjects.iframeDeptSide);
//*[@id="google_ads_iframe_/6011/BestBuyDesktopWeb/appliances/refrigerators_1"]
        switchIFrame(AdPageObjects.iframeDeptSide);

        System.out.println("Department side kick is "+AdPageObjects.depSideKick);
        return getDimension(AdPageObjects.depSideKick);
    }

}
