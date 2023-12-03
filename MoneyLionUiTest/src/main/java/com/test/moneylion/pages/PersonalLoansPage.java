package com.test.moneylion.pages;

import com.framework.Helper.WaitHelper;
import com.framework.base.LocalBrowserInitialzation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PersonalLoansPage {

    public PersonalLoansPage(WebDriver driver) {
        LocalBrowserInitialzation.driver = driver;
        PageFactory.initElements(LocalBrowserInitialzation.driver, this);

    }

    @FindBy(how = How.CSS, using = "h1[class='wp-block-heading ml-hero__title']")
    WebElement matchedWithPersonalLoanOfferstext;

    @FindBy(how = How.CSS, using = "div[id='personal-loan-widget']")
    WebElement loadWidgetBox;

    public String  getMatchedWithPersonalLoanOfferstext(){
        WaitHelper.isvisible(matchedWithPersonalLoanOfferstext, LocalBrowserInitialzation.driver);
        return this.matchedWithPersonalLoanOfferstext.getText();
    }

    public List<String> getTextForLoanWidgets() {
        List<String> list = new ArrayList<>();
        WebElement shadowRoot = loadWidgetBox.getShadowRoot().findElement(By.cssSelector("span[class='sc-kAyceB bTqkjW']"));
        WaitHelper.isClickable(shadowRoot, LocalBrowserInitialzation.driver);
        List<WebElement> elements = loadWidgetBox.getShadowRoot().findElements(By.cssSelector("span[class='sc-kAyceB bTqkjW']"));
        for (WebElement loanAmount : elements) {
            list.add((String) loanAmount.getText());
        }
        return list;
    }
}
