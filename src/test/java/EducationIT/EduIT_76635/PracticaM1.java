package EducationIT.EduIT_76635;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticaM1 
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
	//Paso 1 : Definir que navegador vamos a utilizar
	WebDriver navegador= new FirefoxDriver();	
	WebDriver navegador2 = new EdgeDriver();
	WebDriver navegador3= new ChromeDriver();
	
	//Abrir Pagina en navegador
	
	navegador.manage().deleteAllCookies();  // Borra cookies
	navegador.manage().window().maximize(); // Maximiza ventana
	navegador.get(url); //Abre navegador y con url definida en la variable
	
	navegador2.manage().deleteAllCookies();  // Borra cookies
	navegador2.manage().window().maximize(); // Maximiza ventana
	navegador2.get(url);
	
	navegador3.manage().deleteAllCookies();  // Borra cookies
	navegador3.manage().window().maximize(); // Maximiza ventana
	navegador3.get(url);
	
	//Escribir palabra que se quiere buscar
	// Ubica el elemento dependiendo localizadir
	WebElement txtBusqueda=navegador.findElement(By.id("search_query_top"));
	WebElement txtBusqueda2=navegador2.findElement(By.id("search_query_top"));
	WebElement txtBusqueda3=navegador3.findElement(By.id("search_query_top"));
	
	//ubicar boton 
	WebElement btnBusqueda=navegador.findElement(By.name("submit_search"));
	WebElement btnBusqueda2=navegador2.findElement(By.name("submit_search"));
	WebElement btnBusqueda3=navegador3.findElement(By.name("submit_search"));
	//WebElement btnBusqueda2=navegador.findElement(By.xpath("//*[@id='searchbox]/button'"));   //localizar con xpath
	
	//comando para enviar palabra al cumpo previamente seteado+
	
	txtBusqueda.sendKeys("dress");
	txtBusqueda2.sendKeys("dress");
	txtBusqueda3.sendKeys("dress");
	
	//Simulacion de <Enter>
	//txtBusqueda.sendKeys(Keys.ENTER);
	
	// simular clic
	btnBusqueda.click();
	btnBusqueda2.click();
	btnBusqueda3.click();
	
	//Ultimo Paso : Cerrar navegador
	navegador.quit();	
	navegador2.quit();
	navegador3.quit();
	}
	
	
	
}
