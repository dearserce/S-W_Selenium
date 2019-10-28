package tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.Utilities;
import data.Data;
import data.Objects.Login;
import pages.LoginPage;

public class TestLogin{

	WebDriver driver;
	Utilities util;
	LoginPage loginPage;
	Data data;
	Login login;
	
	@Before
	public void setup() {
		//We have to set all our enviroment ready
		try{
			System.setProperty(
				Utilities.getDriverType("chrome"),
				Utilities.CHROME_DRIVER_PATH);
			util = new Utilities(driver);
			driver = new ChromeDriver();			 
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong while setting up the enviroment");
		}
	}
	
	@Test
	public void LoginHappyPath(){
		try {
			data = new Data("Login"); //sheet
			driver.get(LoginPage.url); //Static final url, expected.
			loginPage = new LoginPage(driver); //Telling Login class we are going to use the same driver.
			login = data.getValuesFromId("T1");
			loginPage.LoginToSystem(
					login.getUsername(), 
				   	login.getPassword(), 
					login.getRememberMe());
			Assert.assertTrue(login.getExpectedResult(),true);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong while testing");
		}
			
	}
	
	@After
	public void after() {
		driver.quit();
	}
}
