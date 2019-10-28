package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	public static String CHROME_DRIVER_PATH = "C:\\selenium\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;
	WebDriverWait wait;
	
	public Utilities(WebDriver driver) {
		this.driver = driver;
		//wait = new WebDriverWait(this.driver, 10);
	}
	
	//We have a general comparison between the actual label and expected
	public boolean IsLabelDisplayedAsExpected(String valor, By label) {
		String labelTxt =driver.findElement(label).getText();
		if(labelTxt.equals(valor)) {
			return true;
		}else {
			return false;
		}	
	}
	
	//When someone tries to click on an element, if that element
	//is not well displayed or something, this will throw an error
	//we can manage that exception with this method.
	public void clickOnElement(By element) {
		try {
			driver.findElement(element).click();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Create a web element from a By element in order to interact.
	public WebElement create (By e) {
		WebElement webElem = null;
		wait = new WebDriverWait(this.driver, 10);
		try {
			webElem= wait.until(ExpectedConditions.visibilityOfElementLocated(e));
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		return webElem;
	}
	
	//Check if checkbox input is selected.
	public boolean isCheckboxSelected(By element) {
		WebElement we = this.create(element);
		if(we.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean isCheckboxSelected(WebElement element) {
		if(element.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getDriverType(String type) {
		switch(type){
		case "chrome":
			return "webdriver.chrome.driver";
		default:
			return "webdriver.chrome.driver";
		}
	}
	
}
