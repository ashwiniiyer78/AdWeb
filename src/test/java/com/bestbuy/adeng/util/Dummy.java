package com.bestbuy.adeng.util;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.net.ssl.SSLHandshakeException;

public class Dummy {

   /* private  WebDriver driver = null;
    private ExtentTest test = null;

    public Dummy(WebDriver driver){
        this.driver = driver;
        test = DriverUtil.getExtentReport("BrokenLinks test");

    }
    public  void  printBrokenLinks(String homePage){
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        driver.get(homePage);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();
        int validCount = 0;
        int invalidCount = 0;
        int totalCount = 0;
        while (it.hasNext()) {
            totalCount++;
            /*if (!url.contains("bestbuy")) {
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }

            try {
                WebElement ele = it.next();
                if(ele!=null) {

                    url = ele.getAttribute("href");
                    if (url == null || url.isEmpty()) {
                        test.log(Status.FAIL, "URL is either not configured for anchor tag or it is empty");
                        invalidCount++;
                        continue;
                    }
                    huc = (HttpURLConnection) (new URL(url).openConnection());

                    huc.setRequestMethod("HEAD");

                    huc.connect();

                    respCode = huc.getResponseCode();

                    if (respCode >= 400) {
                        test.log(Status.FAIL, url + " is a broken link:: response code is " + respCode);
                        invalidCount++;
                    } else {
                        test.log(Status.INFO, url + " is a valid link");
                        validCount++;
                    }
                }

            } catch (java.net.ConnectException cne) {
                test.log(Status.FAIL,"Connection to URL Refused::url" + url);
            }catch(SSLHandshakeException ssle){System.out.println(ssle.getMessage());}
            catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
            finally {
                driver.quit();
            }
        }
        test.log(Status.PASS,"Valid count is " + validCount + "invalid link count " + invalidCount);
        test.log(Status.PASS,"The total url count is ::" + totalCount);
        driver.quit();

    }
*/
}