package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.Utilities;

public class Login{

	WebDriver driver;
	Utilities utilities;
	
	//Page
	public static final String url = "https://test.scorenwod.com/Account/Login";
	
	//Locators
	private final By lblIniciarSesion 			= By.xpath("//h2['Iniciar sesión']");
	private final By lblProporcionaCredenciales = By.xpath("//h4['Proporciona tus credenciales.']");
	private final By lblCorreo 					= By.xpath("//label[@class=\"control-label\" and @for=\"Email\"]");
	private final By lblPassword 				= By.xpath("//label[@class=\"control-label\" and @for=\"Password\"]");
	private final By lblRemember 				= By.xpath("//label[@for=\"RememberMe\"]");
	
	private final By inptCorreo 				= By.xpath("//input[@class=\"form-control\" and @id=\"Email\"]");
	
	private final By inptPassword 				= By.xpath("//input[@class=\"form-control\" and @id=\"Password\"]");
	private final By inptRemember 				= By.xpath("//input[@id=\"RememberMe\" and @type=\"checkbox\"]");
	
	private final By btnSubmit 					= By.xpath("//input[@type=\"submit\" and @class=\"btn btn-primary\" and @value =\"Iniciar sesión\"]");
	private final By aForgotPassword 			= By.xpath("//a[@href=\"/Account/ForgotPassword\"]");
	
	//WebElements, elementes we are going to interact with.
	private WebElement weCorreo;
	private WebElement wePassword;
	private WebElement weRemember;
	private WebElement weSubmit;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		utilities = new Utilities(this.driver);
	}
	
	//Methods
	public void LoginToSystem(String email, String password, boolean remember) {
		try{
		
		weCorreo = utilities.create(inptCorreo);
		weCorreo.clear();
		weCorreo.sendKeys(email);
		
		wePassword=utilities.create(inptPassword);
		wePassword.clear();
		wePassword.sendKeys(password);
		
		weRemember = utilities.create(inptRemember);
		if(remember){
			if(!utilities.isCheckboxSelected(weRemember)) {
				weRemember.click();
			}
		}else {
			//means remember is false.
			if(utilities.isCheckboxSelected(weRemember)) {
				weRemember.click();
			}
		}
		
		weSubmit = utilities.create(btnSubmit);
		weSubmit.click();
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Login error: "+e);
		}
		
	}
	
	//Set only email
	public void setEmail(String email) {
		weCorreo = utilities.create(inptCorreo);
		weCorreo.clear();
		weCorreo.sendKeys(email);
	}
	//set only password
	public void setPassword(String password) {
		wePassword = utilities.create(inptPassword);
		wePassword.clear();
		wePassword.sendKeys(password);
	}
	//Set only remember me checkbox
	public void setRememberMeCheckbox(boolean bol) {
		weRemember = utilities.create(inptRemember);
		if(bol) {
			//Means you want to activate checkbox
			if(!utilities.isCheckboxSelected(weRemember)) {
				weRemember.click();				
			}
		}else {
			//Means you dont want to activate checkbox
			//So we have to be secure that is not selected
			if(utilities.isCheckboxSelected(weRemember)) {
				weRemember.click();
			}
		}
	}
	//click on submit button
	public void clickSubmitOnly() {
		utilities.clickOnElement(btnSubmit);
	}
	
	//Click on forgot password
	public void clickForgotPassword() {
		utilities.clickOnElement(aForgotPassword);
	}
	
	//Getters for later comparison
	public By getLblIniciarSesion() {
		return lblIniciarSesion;
	}

	public By getLblProporcionaCredenciales() {
		return lblProporcionaCredenciales;
	}

	public By getLblCorreo() {
		return lblCorreo;
	}

	public By getLblPassword() {
		return lblPassword;
	}

	public By getLblRemember() {
		return lblRemember;
	}
	
}
