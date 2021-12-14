package com.bestbuy.adeng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdPageObjects {

    @FindBy(xpath ="//button[@aria-label='Menu']")
    public static WebElement buttomTop;


    @FindBy(xpath ="//button[contains(@type,'button'])")
    public static WebElement topbutton;

    @FindBy(css = "button.c-button-unstyled.hamburger-menu-flyout-list-item")
    public static WebElement buttonCat;

    @FindBy(xpath = "//button[text() = 'Vacuums & Floor Care']")
    public static WebElement butoonVac;

    @FindBy(css ="button.c-button-unstyled.hamburger-menu-flyout-list-item")
    public static WebElement catBut;

    @FindBy(partialLinkText="Cooktops")
    public static WebElement category;

    @FindBy(xpath = "//div[@class='ninja-carousel']")
    public static WebElement couroselDiv;

    @FindBy(css ="button.c-close-icon.c-modal-close-icon")
    public static WebElement pupup;

    @FindBy(css ="div.pl-flex-carousel")
    public static WebElement sponsorDiv;

    @FindBy(css = "input#gh-search-input")
    public static WebElement searchTextBox;

    @FindBy( css= "button.header-search-button")
    public static WebElement searchButton;

    @FindBy(css="div.pm-content-container.custom-text-position")
    public static WebElement heroAd;

    @FindBy(css = "div.pl-flex-carousel")
    public static WebElement Ad3sku;

    @FindBy(xpath ="//div[@id ='widget-b7003d0a-1728-4ed7-ab61-ab4c4bd6accd']/parent::div")
    public static WebElement categorySideKick;

    @FindBy(xpath ="//button[@data-id ='node-402']")
    public static WebElement catDept;

    @FindBy(xpath ="//button[@data-id ='node-297']")
    public static WebElement SubCat;

    @FindBy(linkText="Laptops")
    public static WebElement lap;

    @FindBy(css ="div#cb-panel-left-78658318-1caa-485e-bd38-ee907d18061b")
    public static WebElement deptSideKickAd;

    @FindBy(xpath = "//button[@data-id ='node-155']")
    public static WebElement vacBut;

    @FindBy(linkText="Upright Vacuums")
    public static WebElement uprightVaccum;

    @FindBy(tagName = "img")
    public static WebElement skyscraperAd;

    @FindBy(xpath = "//button[@data-id ='node-113']")
    public static WebElement majorKitApp;


    @FindBy(linkText = "Refrigerators")
    public static WebElement regfrig;


    @FindBy(linkText = "Thoughts on this ad?")
    public static WebElement thoughtsSurvey;

    @FindBy(xpath = "//div[(@class='shop-display-ad')]/div/div/div/div/iframe")
    public static WebElement iframeDeptSide;


    @FindBy(xpath = "//div[@id='container']")
    public static WebElement depSideKick;

}
