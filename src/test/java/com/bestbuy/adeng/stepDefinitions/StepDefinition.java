package com.bestbuy.adeng.stepDefinitions;


import com.bestbuy.adeng.pages.AdPageObjects;
import com.bestbuy.adeng.pages.BBYHomePage;
import com.bestbuy.adeng.util.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import java.util.concurrent.TimeUnit;


public class StepDefinition {
    public static WebDriver driver = null;

    public static BBYHomePage homepage = null;
    private static final String baseURL = "https://www.bestbuy.com";
    public static Dimension expectedSKU = null;
    public static Dimension expectedSpon = null;
    public static ExtentTest test = null;
    public ExtentReports report = null;

    Dimension actualSpon = null;
    Dimension actual3SKU = null;

    @Given("User is on betbuy page")
    public void user_is_on_betbuy_page() {
         report = DriverUtil.getExtentReports();

        test = DriverUtil.getExtentReport("Ad Web:  Ad Size Testing");

        expectedSKU = new Dimension(1043, 265);
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
        test.log(LogStatus.PASS, "Closed the popup");
        try{
        Thread.sleep(3000);}catch(Exception e ){e.printStackTrace();}
        Dimension heroAdSize = homepage.getDimensionHeroAd();
        test.log(LogStatus.PASS,"Hero ad is displayed");
        test.log(LogStatus.PASS,"Hero ad height is "+heroAdSize.getHeight()+" Width is "+heroAdSize.getWidth());
        homepage.setTextFieldText(driver, "headphones");
        homepage.scrollScreen2000();
        Dimension recEngineCarosel = homepage.getRecEngineCarouselAd();
        test.log(LogStatus.PASS,"Rec Engine Carousel Ad is displayed");
        test.log(LogStatus.PASS,"Rec Engine Carousel Ad height is "+recEngineCarosel.getHeight()+"  Width is "+recEngineCarosel.getWidth());
    }

    @When("^User searches \"([^\"]*)\"$")
    public void user_searches_something(String strArg1) throws Throwable {



    }

    @Then("^sponsored ad is displayed width \"([^\"]*)\" and height \"([^\"]*)\"$")
    public void sponsored_ad_is_displayed_width_something_and_height_something(String strArg1, String strArg2) throws Throwable {
        int width = Integer.parseInt(strArg1);
        int height = Integer.parseInt(strArg2);
        expectedSpon = new Dimension(width, height);
        Dimension actualSpon = homepage.getSponsoredDim();
        test.log(LogStatus.PASS, "The sponsored ad was visible ");
        test.log(LogStatus.PASS,"Sponsored ad width "+actualSpon.getWidth()+"height  "+actualSpon.getHeight());
        homepage.scrollScreen();
        Dimension actual3SKU = homepage.get3SKUDim();
        test.log(LogStatus.PASS, "The 3sku ad was visible ");
        test.log(LogStatus.PASS,"3SKU ad width "+actual3SKU.getWidth()+" height  "+actual3SKU.getHeight());
        homepage.scrollToTop();



        homepage.clickSVGMenu();
        Dimension skyscraperAd = homepage.findSkyscraperAdSize();
        test.log(LogStatus.PASS,"skyscraper Ad  width "+skyscraperAd.getWidth()+" height  "+skyscraperAd.getHeight());

        Dimension deptSideKick = homepage.findDeptSideKickAdSize();
        test.log(LogStatus.PASS,"department sidekick width "+deptSideKick.getWidth()+" height  "+deptSideKick.getHeight());


        homepage.scrollUp();
        Dimension catsideKick = homepage.findCategorySideKick();
        test.log(LogStatus.PASS,"Category sidekick width "+catsideKick.getWidth()+" height  "+catsideKick.getHeight());
        Thread.sleep(3000);


    }

    @And("close the web page")
    public void close_web_page() {
        driver.close();
        report.endTest(test);
        report.flush();
    }


}