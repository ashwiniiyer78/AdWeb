package com.bestbuy.adeng.util;

import com.bestbuy.adeng.pages.AdPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CollectRequestData {

    @FindBy(xpath ="//div[@class ='goog-rounded-tab-caption']")
    public static WebElement pagerequest;
    public static WebDriver driver = null;

    public  static void generatePageRequest() {
        driver = DriverUtil.getInstance();
        driver.get("https://www.bestbuy.com/?googfc");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try{
            Thread.sleep(3000);}catch(Exception e  ){e.printStackTrace();}
        driver.findElement(By.cssSelector("button.c-close-icon.c-modal-close-icon")).click();
        try{
        Thread.sleep(3000);}catch(Exception e  ){e.printStackTrace();}
        WebElement iframe = driver.findElement(By.xpath("//div[@id='google_pubconsole_console']/iframe"));
        System.out.println(iframe);
        driver.switchTo().frame(iframe);
        try{
            Thread.sleep(3000);}catch(Exception e  ){e.printStackTrace();}
        WebElement pagereqtab = driver.findElement(By.xpath("//div[@aria-selected ='false']/table/tbody/tr[2]/td/div"));
        System.out.println("Page request tab here "+pagereqtab.getText());
        pagereqtab.click();
       WebElement table =  driver.findElement(By.xpath("//table[@id = 'trace-events-table']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<WebElement> cols = null;
        HashMap<String,String> requestMap = new HashMap<String,String>();
        for (WebElement r:rows) {
           cols=r.findElements(By.tagName("td"));
           if(cols.size()==3){
               String content = cols.get(2).getText();
               if(content.contains("=") ||(content.contains(":"))) {
                   storeInMap(requestMap, content);
               }


           }

        }
        for (Map.Entry<String,String> entry : requestMap.entrySet()) {
            System.out.println("key is "+entry.getKey() + ":" +"value is "+ entry.getValue());
        }


    }
    public static void storeInMap(HashMap requestMap,String textContent){
        String [] tokens = textContent.split(":|=");
        requestMap.put(tokens[0],tokens[1]);
    }
    public static void main(String args []){
        generatePageRequest();
    }


}
