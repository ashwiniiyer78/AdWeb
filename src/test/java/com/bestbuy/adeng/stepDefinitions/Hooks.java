package com.bestbuy.adeng.stepDefinitions;

import com.bestbuy.adeng.pages.BBYHomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v94.console.Console;
import org.openqa.selenium.devtools.v94.network.Network;
import org.openqa.selenium.devtools.v94.network.model.Request;
import org.openqa.selenium.devtools.v94.network.model.Response;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Hooks {


    ExtentReports report = null;
    ExtentTest test = null;
    ArrayList<String> urlList = null;
    BBYHomePage homepage = null;
    ChromeDriver driver = null;

    public Hooks() {

    }

    @Before
    public void initDriver() {

       System.out.println("Init driver method before in hooks ");

    }
    public static int getChildAdsSize(ChromeDriver driver ){
        int size = 0;
        WebElement alladsense = driver.findElement(By.xpath("//div[@class ='child-items-wrapper']"));
        if(alladsense!=null){
            List<WebElement> elements = alladsense.findElements(By.tagName("li"));
            List<WebElement> elementHidden = driver.findElements(By.cssSelector("[display=none]"));
            int count = elementHidden.size();
            System.out.println("The number of elements hidden :::"+count);
            System.out.println("The number of elements in adsense are ::"+elements.size());
            size = elements.size();
        }
        return size;
    }


    @After
    public void teardown() {
        System.out.println("Close browser");


    }
}