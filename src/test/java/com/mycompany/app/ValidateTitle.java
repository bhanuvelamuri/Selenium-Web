package com.mycompany.app;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.AssertJUnit;
import java.io.IOException;
import pageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void Initilize() throws IOException {
		driver = initializeDriver();
		Log.info("Driver is initilized");
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to Homepage");
	}
	@Test
	public void basePageNavigation() throws IOException {
		LandingPage l = new LandingPage(driver);
		//compare the text from the browser 
		AssertJUnit.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		AssertJUnit.assertTrue(l.getTitle().isDisplayed());
		Log.info("Successfully Validated Text Message");
	}
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
	
}
