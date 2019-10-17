package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {

	WebDriver driver;
	
	//Page
	public static final String url = "https://test.scorenwod.com/Home";
	
	//Locators
	private final By aLogo = 	By.xpath("//a[@href='/Home']");
	private final By aInicio = 	By.xpath("//a[@href='/']"); 
	private final By aLogin =	By.xpath("//a[@href='/Account/Login']");
	//private final List<By> competitionList = null;
	//Falta el arreglo de total de eventos.
	
	public Home(WebDriver driver) {
		this.driver = driver;
		//So, at this moment we are on the webpage, we can check for competitions
		//fill competition list
	}
	
	public void clickOnALogo() {
		driver.findElement(aLogo).click();
	}
	public void clickOnAInicio() {
		driver.findElement(aInicio).click();
	}
	public void clickOnALogin() {
		driver.findElement(aLogin).click();
	}
	public Boolean isThereAnyCompetition() {
		return false; //WIP
	}
	public int counCompetitions() {
		return 0; //WIP
	}
}
  