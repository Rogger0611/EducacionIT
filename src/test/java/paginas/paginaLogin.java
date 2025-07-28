package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class paginaLogin {
	WebDriver driver;
	
	//Locators 
	By emailField=By.id("email");
	By passwordField=By.id("passwd");
	By loginButton=By.id("SubmitLogin");
	By TitleForm=By.xpath("//h1[contains(text(),'Authen')]");
	By TitleAccount=By.xpath("//h1[contains(text(),'My account')]");
	By signOutButton=By.linkText("Sign out");
	
	//Constructor
	public paginaLogin(WebDriver driver) {
		this.driver=driver;
	}
	
	//Metodo para Ingresar Datos
	public void ingresarDatos(String email,String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	//Metodo para Obtener Titulo
	public String getTitleForm() {		
		return driver.findElement(TitleForm).getText();
	}
	
	//Metodo para Obtener Titulo My Account
		public String getTitleAccount() {
			return driver.findElement(TitleAccount).getText();
		}
		
	//Metodo para Salir My Account
		public void logOut() {
		  driver.findElement(signOutButton).click();
		}
}
