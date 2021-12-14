package com.bestbuy.adeng;

import com.relevantcodes.extentreports.ExtentReports;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"classpath:/features/AdPage.feature"},
        glue = {"com.bestbuy.adeng.stepDefinitions"},
        tags = "@RegTest",
        plugin = {"pretty", "html:target/cucumber.html",
        "json:target/cucumber.json"}
)

public class TestRunner {
    final static Logger logger = Logger.getLogger("TestRunner.class");
    static ExtentReports extent;
    final static String filePath = "ExtentOutput.html";
    static String  fileName="Run_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    public synchronized static ExtentReports getReporter() {
        logger.info("TestRunner.getReporter  started here !");
        if (extent == null) {
            logger.info("Singleton loading !");
            extent = new ExtentReports("./test-output/ExtentReport/"+ fileName + "/" + filePath, true);
        }
        return extent;
    }

}
