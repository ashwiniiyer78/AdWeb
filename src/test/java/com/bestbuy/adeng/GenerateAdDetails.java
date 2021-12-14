package com.bestbuy.adeng;

import com.bestbuy.adeng.util.CollectDataGC;
import com.bestbuy.adeng.util.DriverUtil;
import org.openqa.selenium.WebDriver;

public class GenerateAdDetails {
    public static void main(String args []){
        WebDriver driver = DriverUtil.getInstance();
        CollectDataGC cg = new CollectDataGC();
        cg.generateAdDetails(driver);
    }
}
