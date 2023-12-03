package com.test.moneylion;

import bsh.ParseException;
import com.framework.Helper.AssertionHelper;
import com.framework.base.JsonReader;
import com.framework.base.LocalBrowserInitialzation;
import com.test.moneylion.pages.LandingPage;
import com.test.moneylion.pages.PersonalLoansPage;
import com.test.moneylion.testbase.TestBase;
import com.test.moneylion.utility.ConfigReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Tc_02_verify_if_user_able_to_view_personal_loan_offers_and_Select_loan_amount extends TestBase {

    ConfigReader reader = new ConfigReader();
    @Test(priority=0,dataProvider="TestData")
    public void verify_if_user_able_to_view_personal_loan_offers_and_Select_loan_amount(String LoanAmountValue$500,String LoanAmountValue$1000, String LoanAmountValue$10000, String LoanAmountValueOther ) {

        LandingPage landingPage=new LandingPage(LocalBrowserInitialzation.driver);
        PersonalLoansPage personalLoansPage=new PersonalLoansPage(LocalBrowserInitialzation.driver);
        landingPage.
                hoverOnMarketPlaceMenu()
                .clickOnItemsUnderMarketPlace("PERSONAL LOANS");
        AssertionHelper.softAssertToCompareString(personalLoansPage.getMatchedWithPersonalLoanOfferstext(),"Get matched with personal loan offers","Get matched with personal loan offers not found");
        personalLoansPage.getTextForLoanWidgets();
        AssertionHelper.softAssertToCompareString(personalLoansPage.getTextForLoanWidgets().get(0),LoanAmountValue$500,"Loan amount value $500 mismatched");
        AssertionHelper.softAssertToCompareString(personalLoansPage.getTextForLoanWidgets().get(1),LoanAmountValue$1000,"Loan amount value $1,000 mismatched");
        AssertionHelper.softAssertToCompareString(personalLoansPage.getTextForLoanWidgets().get(2),LoanAmountValue$10000,"Loan amount value $10,000 mismatched");
        AssertionHelper.softAssertToCompareString(personalLoansPage.getTextForLoanWidgets().get(3),LoanAmountValueOther,"Loan amount other mismatched");

    }
    @DataProvider(name="TestData")
    public Object[][] passData() throws IOException, ParseException
    {
        return JsonReader.getdata(System.getProperty("user.dir")+reader.testDataPath(),
                "Testdata_Tc_02_verify_if_user_able_to_view_personal_loan_offers_and_Select_loan_amount", 1, 4);

    }
}