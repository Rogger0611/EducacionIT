package paginas;

import org.openqa.selenium.WebDriver;

import utils.CommonMethods;

import org.openqa.selenium.By;
public class paginaLogin2 {
	 WebDriver driver;
	    
	 CommonMethods actions;

	    By emailField = By.id("email");
	    By passwordField = By.id("passwd");
	    By loginButton = By.id("SubmitLogin");
	    By titleForm = By.xpath("//h1[contains(text(),'Authen')]");
	    By titleAccount = By.xpath("//h1[contains(text(),'My account')]");
	    By signOutButton = By.linkText("Sign out");

	    public paginaLogin2(WebDriver driver) {
	        this.driver = driver;
	        this.actions = new CommonMethods(driver);
	    }

	    public void ingresarDatos(String email, String password) {
	        actions.escribirTexto(emailField, email);
	        actions.escribirTexto(passwordField, password);
	        actions.hacerClick(loginButton);
	        
	        
	    }

	    public String getTitleForm() {
	        return actions.obtenerTexto(titleForm);
	    }

	    public String getTitleAccount() {
	        return actions.obtenerTexto(titleAccount);
	    }

	    public void logOut() {
	        actions.hacerClick(signOutButton);
	    }

	    public boolean isLoginSuccessful() {
	        return actions.estaPresente(titleAccount);
	    }
}

