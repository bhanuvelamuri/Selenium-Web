package com.mycompany.app;

import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.logging.log4j.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public static Logger Log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void Initilize() throws IOException {
		
	}
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password) throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getemail().sendKeys(Username);
		lp.getpassword().sendKeys(Password);
		lp.getlogin().click();
		Log.info("Homepage Verified");
		
	}
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
	@DataProvider
	public Object[][] getData() {
		//Row stands for how many data types tests should run
		//Column stands for how many values per each test
		Object[][] data = new Object[2][2];
		//at zeroth row
		data[0][0]="bhanu.p@gmail.com";
		data[0][1]="dmfdf";
		//at 1st row
		data[1][0] = "bhanu@gmail.com";
		data[1][1] = "545124";
		return data;
		
	}

}
