package EducationIT.EduIT_76635;

import java.time.Duration;

//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PracticaM2 
{
		//variables
		String url="http://www.automationpractice.pl/index.php";
		
		@Test
		public void registrarUsuario() throws InterruptedException
		{
			//1 Navegador
			WebDriver navegador= new ChromeDriver();
			
			//2 Abrir pagina
			navegador.manage().deleteAllCookies();  // Borra cookies
			navegador.manage().window().maximize(); // Maximiza ventana
			navegador.get(url);
			
			//3 Hacer click en Sign in
			WebElement lnkSign=navegador.findElement(By.partialLinkText("Sign"));  //busqueda parcial con partial link , busca entre etiquetas texto parcial
			lnkSign.click();
			
			//4 digitar correo
			String MailUsed= "correoXXjul"+Math.random()+"@gmail.com";
			WebElement txtMail=navegador.findElement(By.id("email_create"));
			txtMail.sendKeys(MailUsed);  // math.random -> para aumentar correo para evitar datos repetidos
			System.out.println("Correo Usado en el test :"+MailUsed);
			
			
			//5 clic en Create an account
			WebElement btnCreate=navegador.findElement(By.name("SubmitCreate"));
			btnCreate.click();
			
			// 6 pendiente - Colocar espera para carga de elementos - Hasta que Radiobutton renderice
			WebDriverWait espera=new WebDriverWait(navegador,Duration.ofSeconds(10));
			espera.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
			
			//Thread.sleep(1500); dormir hilo de automation
			
			//RadioButton
			WebElement btnGender=navegador.findElement(By.id("id_gender1"));
			btnGender.click();
			
			//Thread.sleep(1500);  // Colocar espera 
			
			//7 escribir nombre
			WebElement txtNombre=navegador.findElement(By.id("customer_firstname"));
			txtNombre.sendKeys("Roger");
			
			//8 escribir apellido
			WebElement txtApellido=navegador.findElement(By.cssSelector("#customer_lastname"));
			txtApellido.sendKeys("Rodriguez");
			
			//9 limpiar correo del form
			WebElement txtEmail=navegador.findElement(By.id("email"));
			txtEmail.clear();
			
			//10 escribir correo
			WebElement txtMailUsed=navegador.findElement(By.id("email"));
			txtMailUsed.sendKeys(MailUsed);
			
			//11 escribir pass
			String Pass= "correoXXjul"+Math.random();
			WebElement txtPass=navegador.findElement(By.id("passwd"));
			txtPass.sendKeys(Pass);
			System.out.println("Pass usado en el test"+Pass);
			
			//12 selecciones fecha lista desplegable
			Select Lstdias = new Select(navegador.findElement(By.id("days")));
			Lstdias.selectByValue("31");
			
			Select LstMes = new Select(navegador.findElement(By.name("months")));
			LstMes.selectByIndex(12);
			
			Select LstAño = new Select(navegador.findElement(By.name("years")));
			LstAño.selectByVisibleText("1990  ");
			
			
			//13 click en checkbox
			WebElement chkNews=(navegador.findElement(By.name("newsletter")));
			chkNews.click();
			
			//14 Clic en Registrar
			WebElement btnRegistro= navegador.findElement(By.id("submitAccount"));
			btnRegistro.click();
			
			//
			
			//logout
			//WebElement txtLogOut= navegador.findElement(By.className("logout"));
			//txtLogOut.click();
			
			//16 login
			
		}
}
