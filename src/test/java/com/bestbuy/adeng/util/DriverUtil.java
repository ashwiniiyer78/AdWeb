package com.bestbuy.adeng.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class DriverUtil {
    private DriverUtil(){

    }
    private static WebDriver driver;
    private static ExtentReports report= null;
    public static ExtentTest test = null;
    public static WebDriver getInstance() {
        if (driver == null) {
            String browser = "";
            try {
                ClassLoader classLoader = DriverUtil.class.getClassLoader();

                // Make sure that the configuration file exists
                URL res = classLoader.getResource("config.properties");
                InputStream configurations = new FileInputStream(res.getFile());
                Properties prop = new Properties();
                prop.load(configurations);
                browser = prop.getProperty("browser");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (browser.equals("chrome")) {
                driver = new ChromeDriver();

            } else if (browser.equals("firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equals("IE")) {
                driver = new InternetExplorerDriver();
            }
            return driver;
        }else{
            return driver;
        }
    }
    public static ExtentReports getExtentReports(){
        report = new ExtentReports("Pink.html");
        return report;
    }
    public static ExtentTest getExtentReport(String testName){
        report = getExtentReports();
        test = report.startTest(testName);
        return test;
    }
    public static String captureScreenShot(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("AdPageScreenERR/" + System.currentTimeMillis()
                + ".png");
        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, Dest);
        return errflpath;
    }

}
