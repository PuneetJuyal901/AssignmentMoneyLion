package com.test.moneylion;


import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.Helper.AssertionHelper;
import com.framework.base.JsonReader;
import com.framework.base.LocalBrowserInitialzation;
import com.test.moneylion.pages.CareersPage;
import com.test.moneylion.pages.LandingPage;
import com.test.moneylion.testbase.TestBase;
import com.test.moneylion.utility.ConfigReader;

import bsh.ParseException;


public class Tc_01_verify_if_user_able_to_access_about_page_successfully extends TestBase {


    ConfigReader reader = new ConfigReader();

    @Test(priority = 0, dataProvider = "TestData")
    public void verify_if_user_able_to_access_about_page_successfully(String FigureCaptionNewYorkCiyText, String FigureCaptionSiouxFalls, String FigureCaptionKaulaLumPurText, String FigureCaptionAroundTheGlobeText) {
        LandingPage landingPage = new LandingPage(LocalBrowserInitialzation.driver);
        CareersPage careersPage = new CareersPage(LocalBrowserInitialzation.driver);
        landingPage.
				hoverOnAboutUsMenu().
				clickOnAboutUsDropDownValues();

        AssertionHelper.softAssertToCompareString(careersPage.getTextOfFigureCaption(0), FigureCaptionNewYorkCiyText, "New york city text not found");
        AssertionHelper.softAssertToCompareString(careersPage.getTextOfFigureCaption(1), FigureCaptionSiouxFalls, "sixoux falls  text not found");
        AssertionHelper.softAssertToCompareString(careersPage.getTextOfFigureCaption(2), FigureCaptionKaulaLumPurText, "kaula lumpurtext not found");
        AssertionHelper.softAssertToCompareString(careersPage.getTextOfFigureCaption(3), FigureCaptionAroundTheGlobeText, "around the globe text not found");

    }

    @DataProvider(name = "TestData")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getdata(System.getProperty("user.dir") + reader.testDataPath(), "Testdata_Tc_01_verify_if_user_able_to_access_about_page_successfully", 1, 4);

    }

}