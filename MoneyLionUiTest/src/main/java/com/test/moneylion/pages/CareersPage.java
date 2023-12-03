package com.test.moneylion.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.Helper.ActionHelper;
import com.framework.base.LocalBrowserInitialzation;

public class CareersPage {

	public CareersPage(WebDriver driver) {
		LocalBrowserInitialzation.driver = driver;
		PageFactory.initElements(LocalBrowserInitialzation.driver, this);

	}

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'where-we-work-cities')]//figcaption")
	List<WebElement>figureCaption;


   
   public String getTextOfFigureCaption(int num) {
	   return  figureCaption.get(num).getText();
	   
		      
   }
}