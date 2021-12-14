package com.bestbuy.adeng.stepDefinitions.stepSurvey;

import com.bestbuy.adeng.pages.AdPageObjects;
import com.bestbuy.adeng.pages.BBYHomePage;
import com.bestbuy.adeng.util.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class StepSurvey {
    public static WebDriver driver = null;

    public static BBYHomePage homepage = null;
    private static final String baseURL = "https://www.bestbuy.com";
    public static Dimension expectedSKU = null;
    public static Dimension expectedSpon = null;
    public static ExtentTest test = null;
    public ExtentReports report = null;
    @Given("user is on refigerators page")
    public void user_is_on_refigerators_page() {
        report = DriverUtil.getExtentReports();

        test = DriverUtil.getExtentReport("Ad Web:  Ad Size Testing");
        driver = DriverUtil.getInstance();
        System.out.println(driver);
        driver.get(baseURL);
        AdPageObjects page = new AdPageObjects();
        PageFactory.initElements(driver, page);
        test.log(LogStatus.PASS, "Navigated to best buy site.");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        homepage = new BBYHomePage(driver);

        homepage.closePopUP();
        try{
            Thread.sleep(3000);}catch(Exception e ){e.printStackTrace();}
        test.log(LogStatus.PASS, "Closed the popup");
        homepage.goToRefrigeratorPage();


    }
    @Then("Thoughts on this ad is visible")
    public void thoughts_on_this_ad_is_visible() {
        System.out.println(homepage.thoughtVisible());


    }
    @And("User able to give a survey")
    public void user_able_to_give_a_survey() {

     homepage.sendFeedback();

    }
    @And("close web page")
    public void close_web_page() {
        // Write code here that turns the phrase above into concrete actions
        if(driver!=null){
            driver.close();
        }
        report.flush();
        report.endTest(test);
       System.out.println("Close ");
    }

}
