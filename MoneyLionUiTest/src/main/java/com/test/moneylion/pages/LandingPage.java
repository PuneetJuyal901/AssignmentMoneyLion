package com.test.moneylion.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.Helper.ActionHelper;
import com.framework.Helper.WaitHelper;
import com.framework.base.LocalBrowserInitialzation;

public class LandingPage {

    public LandingPage(WebDriver driver) {
        LocalBrowserInitialzation.driver = driver;
        PageFactory.initElements(LocalBrowserInitialzation.driver, this);

    }

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'About Us')]")
    WebElement aboutUsMenu;


    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Careers')]")
    WebElement Careers;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Marketplace')]")
    WebElement marketPlaceMenu;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Marketplace')]/following-sibling::div//a")
    List<WebElement> marketPlaceMenuItems;

    public LandingPage hoverOnAboutUsMenu() {

        WaitHelper.isvisible(aboutUsMenu, LocalBrowserInitialzation.driver);
        ActionHelper.mouseHover(LocalBrowserInitialzation.driver, aboutUsMenu);
        return new LandingPage(LocalBrowserInitialzation.driver);
    }

    public LandingPage hoverOnMarketPlaceMenu() {

        WaitHelper.isvisible(marketPlaceMenu, LocalBrowserInitialzation.driver);
        ActionHelper.mouseHover(LocalBrowserInitialzation.driver, marketPlaceMenu);
        return new LandingPage(LocalBrowserInitialzation.driver);
    }

    public LandingPage clickOnAboutUsDropDownValues() {
        WaitHelper.isClickable(Careers, LocalBrowserInitialzation.driver);
        ActionHelper.clickonElement(Careers, LocalBrowserInitialzation.driver);
        return new LandingPage(LocalBrowserInitialzation.driver);

    }

    public void clickOnItemsUnderMarketPlace(String value) {
        for(WebElement listOfElement : marketPlaceMenuItems) {
            if (listOfElement.getText().equals(value)) {
                WaitHelper.isvisible(listOfElement, LocalBrowserInitialzation.driver);
                ActionHelper.clickonElement(listOfElement, LocalBrowserInitialzation.driver);
                break;
            }

        }
    }
}


