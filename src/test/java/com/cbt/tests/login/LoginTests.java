package com.cbt.tests.login;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.cbt.pages.AllOrdersPage;
import com.cbt.pages.LoginPage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;

public class LoginTests extends TestBase {

	
	
	
	
	@Test()
	public void positiveloginTest() {
		
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
	}

	
	@Test(priority = 2)
	public void positiveLoginUsingPOM() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userName.sendKeys(ConfigurationReader.getProperty("username"));
		loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
		BrowserUtils.waitForClickablility(driver, loginPage.loginButton, 2);
		loginPage.loginButton.click();

	}

	
	@Test(priority = 1, groups = "functest")
	public void invalidUsernameTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userName.sendKeys("invalid");
		loginPage.password.sendKeys("test");
		loginPage.loginButton.click();
		String errMsg = loginPage.invalidUserNameErrMsg.getText();

		assertEquals(errMsg, "Invalid Login or Password.");
	}

}
