package com.bestbuy.adeng.util;

import com.bestbuy.adeng.AdPage;
import com.bestbuy.adeng.model.AdDetails;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.simple.JSONObject;
import com.bestbuy.adeng.util.DriverUtil;
import com.bestbuy.adeng.util.FileUtil;
import com.bestbuy.adeng.model.AdDetails;
public class CollectDataGC {

    public static WebDriver driver = null;
    public static String NOT_ALLOWED = "Send the above Query ID";
    public static String NOTKEY = "Open Ad Unit in Ad Manage";
    public static int numberOfAd = 2;
    public static FileWriter file = null;



    public  void generateAdDetails(WebDriver driver) {

        driver.get("https://www.bestbuy.com/?googfc");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        try {
            file = new FileWriter("./output.json");

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement iframe = driver.findElement(By.xpath("//div[@id='google_pubconsole_console']/iframe"));
        System.out.println(iframe);
        driver.switchTo().frame(iframe);

        for (int i = 0; i < numberOfAd; i++) {
            WebElement parent = driver.findElement(By.id("ad_unit_" + i + "_info"));
            buildJson(parent);
        }
        try {
            file.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public  AdDetails buildJson(WebElement parent) {
        AdDetails details = new AdDetails();
        List<WebElement> lis = parent.findElements(By.xpath("./child::*"));
        JSONObject json = new JSONObject();
        int total = lis.size();
        for (int i = 0; i < total - 1; i++) {

            String key = lis.get(i).getText();
            String value = lis.get(i + 1).getText();
            if(key.contains("Div:")){
                details.setDivName(key.substring(key.indexOf(":"),key.length()));
            }if(value.contains("Slot size:")){
                int start = value.indexOf(":");
                details.setSlotSize(value.substring(start,value.length()));
            }
            if (key.contains(":")) {
                key = key.substring(0, key.length() - 1);
            }
            if(key.equals("Query ID")){
                details.setQueryId(value.substring(0,value.indexOf("\n")));
            }
            if(key.equalsIgnoreCase("Creative ID")){
                details.setCreativeId(value);
            }
            if(key.equalsIgnoreCase("Overlay status")){

                details.setOverlayStatus(value);
            }
            if(key.equalsIgnoreCase("Iframe type")){details.setIframeType(value);}
            if (value.contains(NOT_ALLOWED)) {
                value = value.substring(0, value.indexOf("\n" + NOT_ALLOWED));

            }
            if(value.contains("ms to fetch")){
                details.setTimeToFetch(key);
            }
            if ((!key.contains(NOT_ALLOWED)) && (!key.contains(NOTKEY))) {

                if (!(key.equals("") || value.equals(""))) {
                    json.put(key, value);
                }
            }
            if (key.equalsIgnoreCase("Query ID")) {
                break;
            }

        }
        try {

            file.write("AD  details :" + json.toJSONString() + "\n\n");

        } catch (IOException e) {

            e.printStackTrace();
        }
        //System.out.println("JSON file created: " + json);
        System.out.println(details);
        return details;

    }

}


