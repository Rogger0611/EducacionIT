package EducationIT.EduIT_76635;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class M1_Xpath 
{
	//variables
	String url="http://www.automationpractice.pl/index.php";
		
	@Test
	@Disabled("Deshabilitar un test case")
	public void lab1_test() 
	{
		System.out.println("Test Pagina de Compras")	; 
	}
	
	@Test
	public void buscarProducto ()
	{
		WebDriver navegador= new FirefoxDriver();	
	
	//Abrir Pagina en navegador
	
	navegador.manage().deleteAllCookies();  // Borra cookies
	navegador.manage().window().maximize(); // Maximiza ventana
	navegador.get(url); //Abre navegador y con url definida en la variable
	
	//Escribir palabra que se quiere buscar
	// Ubica el elemento dependiendo localizadir
	WebElement txtBusqueda=navegador.findElement(By.xpath("//input[@placeholder=\"Search\" and @type=\"text\"]"));   // xpath por atributo
	// WebElement txtBusqueda=navegador.findElement(By.xpath("//input[contains(@id,\"search_query_top\")]"));   // xpath por id 
		
	//ubicar boton 
	WebElement btnBusqueda=navegador.findElement(By.xpath("//button[@type=\"submit\" and @class=\"btn btn-default button-search\"]"));

	//comando para enviar palabra al cumpo previamente seteado+
	
	txtBusqueda.sendKeys("dress");

	//Simulacion de <Enter>
	//txtBusqueda.sendKeys(Keys.ENTER);
	
	// simular clic
	btnBusqueda.click();

	
	//Ultimo Paso : Cerrar navegador
	navegador.quit();	

	}
	
	
	
}
