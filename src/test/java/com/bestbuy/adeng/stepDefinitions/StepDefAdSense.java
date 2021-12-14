package com.bestbuy.adeng.stepDefinitions;

import com.bestbuy.adeng.pages.BBYHomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.tools.javac.comp.Check;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v94.console.Console;
import org.openqa.selenium.devtools.v94.network.Network;
import org.openqa.selenium.devtools.v94.network.model.Request;
import org.openqa.selenium.devtools.v94.network.model.Response;
import org.openqa.selenium.devtools.DevTools;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class StepDefAdSense {
    ExtentReports report = null;
    ExtentTest test = null;
    ArrayList<String> urlList= null;
    BBYHomePage homepage =null;
    ChromeDriver driver =null;

    @Given("User visits betbuy page")
    public void user_is_on_betbuy_page() {
        driver = new ChromeDriver();
        urlList = new ArrayList<String>();
        report = new ExtentReports("AdsenseComponentTesting.html");
        test = report.startTest("Ad sense Component Testing ....");
        DevTools tools = driver.getDevTools();
        tools.createSession();
        tools.send(Console.enable());

        tools.send(Console.clearMessages());

        tools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));


        tools.addListener(Network.responseReceived(), response ->{
            Response res = response.getResponse();

            if((res.getUrl().indexOf("adsense"))!=-1){
                System.out.println("Ad sense urls triggered  #####"+res.getUrl());
                urlList.add(res.getUrl());
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
        homepage =  new BBYHomePage(driver);
        driver.get("https://www.bestbuy.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        try{
            Thread.sleep(3000);}catch(Exception e){}
        driver.findElement(By.cssSelector("button.c-close-icon.c-modal-close-icon")).click();
        try{
            Thread.sleep(3000);}catch(Exception e){}



    }
    public static void searchHeadPhones(ChromeDriver driver, String searchWord){
        System.out.println("Search for headphones");
    }
    @When("User search for {string}")
    public void user_search_for(String string) throws Throwable {
        searchHeadPhones(driver,string);
    }
    @Then("Check if the PLP Page shows the Adsense")
    public void check_if_the_plp_page_shows_the_adsense() {
       System.out.println("log if calls were made");

    }

    @And("close the browser")
    public void close_web_page() {
        driver.close();
        report.endTest(test);
        report.flush();
    }
}
