package tests;

import org.junit.Test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.Utilities;
import data.Data;
import data.ObjectMethods.LoginDataMethods;
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
			String testCaseID = "T1"; //We can make this dynamic
			System.out.println("Testing ["+testCaseID+"] test case");
			data = new LoginDataMethods("Login", Utilities.FILE_PATH); //sheet
			driver.get(LoginPage.url); //Static final url, expected.
			System.out.println("URL :" +LoginPage.url);
			System.out.println();
			loginPage = new LoginPage(driver); //Telling Login class we are going to use the same driver.
			login = (Login) data.getValuesFromId(testCaseID); //Casting to object we want to use
			System.out.println("Using next values: \n" + login.getUsername() + "\n" + login.getPassword() + "\n" + login.getRememberMe());
			loginPage.LoginToSystem(
					login.getUsername(), 
				   	login.getPassword(), 
					login.getRememberMe());
			
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL, login.getExpectedResult());
			System.out.println("Test Passed");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed");
		}
			
	}
	
	@After
	public void after() {
		driver.quit();
	}
}
