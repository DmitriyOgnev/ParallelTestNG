package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public Driver() {
	}

	private WebDriver driver;

	public WebDriver getDriver(String browser) {

		browser = browser == null ? ConfigurationReader.getProperty("browser") : browser;

		if (driver == null) {
			switch (browser) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			}
		}
		return driver;
	}

	public WebDriver getDriver() {
		return getDriver(null);
	}

	public void closeDriver() {
		if (driver != null) {
			driver.close();
			driver = null;
		 }
	}
}
