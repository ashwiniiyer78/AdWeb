package com.bestbuy.adeng;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.bestbuy.adeng.pages.BBYHomePage;
import com.bestbuy.adeng.util.DriverUtil;

import java.util.concurrent.TimeUnit;

public class AdPage {
    public static WebDriver driver = null;

    public static BBYHomePage homepage = null;
    private static final String baseURL = "https://www.bestbuy.com";
    public static Dimension expectedSKU = null;
    public static Dimension expectedSpon = null;
    public static ExtentReports report = null;
    public static ExtentTest test = null;

    @BeforeTest
    public static void setupTest() {
        report = new ExtentReports("./src/test/resources/ExtentReportResults.html");
        test = report.startTest("ScreenSizeTesting");

        expectedSKU = new Dimension(1043, 265);
        expectedSpon = new Dimension(1160, 263);
        driver = DriverUtil.getInstance();
        System.out.println(driver);
        driver.get(baseURL);
        test.log(LogStatus.PASS, "Navigated to best buy site.");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @Test
    public static void testScreenSize() {
        setupTest();
        homepage = new BBYHomePage(driver);

        homepage.closePopUP();
        test.log(LogStatus.PASS, "Closed the popup");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement textf = homepage.getText();
        wait.until(ExpectedConditions.visibilityOf(textf));
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        homepage.setTextFieldText(driver, "blender");


        Dimension actualSpon = homepage.getSponsoredDim();
        homepage.scrollScreen();
        Dimension actual3SKU = homepage.get3SKUDim();
        System.out.println("actual for sponsorship ads" + actualSpon);
        System.out.println("3sku ad size  " + actual3SKU);
        if (expectedSpon.equals(actualSpon)) {
            test.log(LogStatus.PASS, "3 SKU Screen Size Check" + actualSpon);
        }


    }

    @AfterTest
    public static void tearDown() {
        System.out.println("Tests sucessfully Completed");
        driver.close();
        report.endTest(test);
        report.flush();

    }

}
