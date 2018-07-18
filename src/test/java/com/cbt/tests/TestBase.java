package com.cbt.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;

public abstract class TestBase {

	protected WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setUpClass(String browser) {
		
		driver = new Driver().getDriver(browser);
	}
	
	@BeforeMethod
	public void setUp() {
		
		driver.get(ConfigurationReader.getProperty("url"));
	}

	@AfterClass
	public void teardownMethod() {
		driver.close();
	}

}
