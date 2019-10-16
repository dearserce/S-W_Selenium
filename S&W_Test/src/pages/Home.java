package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {

	WebDriver driver;
	
	//Page
	public final String url = "https://test.scorenwod.com/Home";
	
	//Locators
	private final By aLogo = 	By.xpath("//a[@href='/Home']");
	private final By aInicio = 	By.xpath("//a[@href='/']"); 
	private final By aLogin =	By.xpath("//*[@id=\"navbarNav\"]/ul[2]/li/a"); //Revisar xpath
	//Falta el arreglo de total de eventos.
	
	public Home(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnALogo() {
		driver.findElement(aLogo).click();
	}
	public void clickOnAInicio() {
		driver.findElement(aInicio).click();
	}
	public void clickOnALogin() {
		driver.findElement(aLogin).click();;
	}
	public Boolean isThereAnyCompetition() {
		return false; //WIP
	}
	public int counCompetitions() {
		return 0; //WIP
	}
}
  