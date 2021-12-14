package com.bestbuy.adeng.util;


import com.bestbuy.adeng.pages.AdPageObjects;
import com.bestbuy.adeng.pages.BBYHomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

import org.openqa.selenium.devtools.v94.console.Console;
import org.openqa.selenium.devtools.v94.fetch.Fetch;
import org.openqa.selenium.devtools.v94.network.Network;
import org.openqa.selenium.devtools.v94.network.model.Request;
import org.openqa.selenium.devtools.v94.network.model.Response;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;


import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.logging.Level;

public class NetworkTab {
    @FindBy(css ="button.c-close-icon.c-modal-close-icon")
    public static WebElement pupup;
    public static void main(String args[]) {

        ChromeDriver driver = new ChromeDriver();

        try {
            Thread.sleep(2000);
        }catch(Exception e ){}

        DevTools tools = driver.getDevTools();
        tools.createSession();
        tools.send(Console.enable());

        tools.send(Console.clearMessages());

        tools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));


        tools.addListener(Network.responseReceived(), response ->{
            Response res = response.getResponse();

            if((res.getUrl().indexOf("adsense"))!=-1){
                System.out.println("Ad sense urls triggered  #####"+res.getUrl());
            }
        });
        tools.addListener(Network.requestIntercepted(), request ->{
            Request req = request.getRequest();


        });
        tools.addListener(Network.requestWillBeSent(), request ->{
            Request req = request.getRequest();

            if(req.getMethod().equals("Post")) {
              //  System.out.println("request method is " + req.getMethod() + ":::" + req.getHasPostData());
            }

        });
        tools.addListener(Network.loadingFailed(), loadingFailed -> {
               System.out.println(loadingFailed.getBlockedReason());

        });

        BBYHomePage homepage = new BBYHomePage(driver);
        driver.get("https://www.bestbuy.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        try{
        Thread.sleep(3000);}catch(Exception e){}
        driver.findElement(By.cssSelector("button.c-close-icon.c-modal-close-icon")).click();
        try{
            Thread.sleep(3000);}catch(Exception e){}

        WebElement we = driver.findElement(By.cssSelector("input#gh-search-input"));
        File file = we.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("./src/test/resources/logo.png"));
        } catch(Exception e ){e.printStackTrace();}
        we.sendKeys("headphones");



        driver.findElement(By.cssSelector("button.header-search-button")).click();


      }



      public static void getResponse(){

      }
      public static void trythis(){




          ChromeOptions options = new ChromeOptions();
          LoggingPreferences logPrefs = new LoggingPreferences();
          logPrefs.enable( LogType.PERFORMANCE, Level.ALL );
          options.setCapability( "goog:loggingPrefs", logPrefs );

          WebDriver driver = new ChromeDriver(options);
          driver.get("http://www.bestbuy.com");

          driver.findElement(By.cssSelector("input#gh-search-input")).sendKeys("blender");
          driver.findElement(By.cssSelector("button.header-search-button")).click();
          try{
          Thread.sleep(2000);}catch(Exception e ){}
          List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
          System.out.println(entries.size() + " " + LogType.PERFORMANCE + " log entries found");



          for (LogEntry entry : entries) {
              System.out.println(entry.getMessage());
          }

      }

}
