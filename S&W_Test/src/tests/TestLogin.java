package tests;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.Utilities;
import data.Data;
import pages.Login;

public class TestLogin{

	WebDriver driver;
	Utilities util;
	Login login;
	Data data;
	
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
			data = new Data("Login"); //sheet
			
			driver.get(Login.url); //Static final url, expected.
			login = new Login(driver); //Telling Login class we are going to use the same driver.
			login.LoginToSystem(
					"test@scorenwod.com", 
				   	"Compe1234*", 
					true);
			Assert.assertTrue("https://test.scorenwod.com/",true);
	}
	
	@After
	public void after() {
		driver.quit();
	}
}
