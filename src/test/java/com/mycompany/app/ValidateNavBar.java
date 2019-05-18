package com.mycompany.app;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateNavBar extends base  {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void Initilize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void basePageNavigation() throws IOException {
		LandingPage l = new LandingPage(driver);
		//compare the text from the browser 
		AssertJUnit.assertTrue(l.getNavigationbar().isDisplayed());
		
		Log.info("Successfully Validated Text Message");
	}
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
}
