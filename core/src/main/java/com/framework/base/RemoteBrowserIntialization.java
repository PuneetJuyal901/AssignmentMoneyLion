package com.framework.base;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public   class RemoteBrowserIntialization{

  public static final String USERNAME = "puneetjuyal1";
  public static final String AUTOMATE_KEY = "qtswqFpE88CkMkL14ngh";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

  public static void  intitalizeRemoteBrowser(String browserName,String browserVersion,String url,String os,String osVersion
		  ) throws MalformedURLException {

    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browser", browserName);
    caps.setCapability("browser_version", browserVersion);
    caps.setCapability("os", os);
    caps.setCapability("os_version", osVersion);

    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get(url);


 

  }
}