package EducationIT.EduIT_76635;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
//import org.junit.jupiter.api.Disabled;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticaM3 

{
	// Driver
	WebDriver driver;

	// Variables que se neceitan
	String url="http://www.automationpractice.pl/index.php";
	String urlAuthentication="http://www.automationpractice.pl/index.php?controller=my-account";

	@BeforeSuite
	public void setUP()
	{
		//1 Navegador
		driver = new EdgeDriver();
	}

	@BeforeTest
	public void irUrl()
	{
		//Abrir url
		driver.get(url);
	}

	@BeforeClass
	public void maxVentana()
	{
		// maximiza ventana
		driver.manage().window().maximize();
	}

	@Test
	public void registrarUsuario()
	{
		//3 Hacer click en Sign in
		WebElement lnkSign=driver.findElement(By.partialLinkText("Sign"));  //busqueda parcial con partial link , busca entre etiquetas texto parcial
		lnkSign.click();

		//4 digitar correo
		String MailUsed= "correoXXjul"+Math.random()+"@gmail.com";
		WebElement txtMail=driver.findElement(By.id("email_create"));
		txtMail.sendKeys(MailUsed);  // math.random -> para aumentar correo para evitar datos repetidos
		System.out.println("Correo Usado en el test :"+MailUsed);


		//5 clic en Create an account
		WebElement btnCreate=driver.findElement(By.name("SubmitCreate"));
		btnCreate.click();

		// 6 pendiente - Colocar espera para carga de elementos - Hasta que Radiobutton renderice
		WebDriverWait espera=new WebDriverWait(driver,Duration.ofSeconds(10));
		espera.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));

		//Thread.sleep(1500); dormir hilo de automation

		//RadioButton
		WebElement btnGender=driver.findElement(By.id("id_gender1"));
		btnGender.click();

		//Thread.sleep(1500);  // Colocar espera 

		//7 escribir nombre
		WebElement txtNombre=driver.findElement(By.id("customer_firstname"));
		txtNombre.sendKeys("Roger");

		//8 escribir apellido
		WebElement txtApellido=driver.findElement(By.cssSelector("#customer_lastname"));
		txtApellido.sendKeys("Rodriguez");

		//9 limpiar correo del form
		WebElement txtEmail=driver.findElement(By.id("email"));
		txtEmail.clear();

		//10 escribir correo
		WebElement txtMailUsed=driver.findElement(By.id("email"));
		txtMailUsed.sendKeys(MailUsed);

		//11 escribir pass
		String Pass= "correoXXjul"+Math.random();
		WebElement txtPass=driver.findElement(By.id("passwd"));
		txtPass.sendKeys(Pass);
		System.out.println("Pass usado en el test"+Pass);

		//12 selecciones fecha lista desplegable
		Select Lstdias = new Select(driver.findElement(By.id("days")));
		Lstdias.selectByValue("31");

		Select LstMes = new Select(driver.findElement(By.name("months")));
		LstMes.selectByIndex(12);

		Select LstAño = new Select(driver.findElement(By.name("years")));
		LstAño.selectByVisibleText("1990  ");


		//13 click en checkbox
		WebElement chkNews=(driver.findElement(By.name("newsletter")));
		chkNews.click();

		//14 Clic en Registrar
		WebElement btnRegistro= driver.findElement(By.id("submitAccount"));
		btnRegistro.click();

		System.out.println("Url Actual   "+ driver.getCurrentUrl());
		System.out.println("Url Esperada "+ urlAuthentication);
		//15 confirmacion cuenta
		Assert.assertEquals(driver.getCurrentUrl(),urlAuthentication);

	}

	//creacion de otro test
	@Test(priority=2)
	public void validarTituloAccount()
	{
		try
		{
			String tituloEsperado="My account - My Shop";//
			String tituloActual=driver.getTitle();
			System.out.println(" Titulo Esperado :"+tituloActual);
			System.out.println(" Titulo Actual 	 :"+tituloActual);
			Assert.assertEquals(tituloActual, tituloEsperado);
		}
		catch (Throwable e)
		{
			System.out.println("Error al validar el titulo de la cuenta "+e.getMessage());
			tomarCaptura("error_validarTituloAccount");
			Assert.fail("Fallo el test por AssertionError. ");
		}
	}

	public void tomarCaptura(String nombreArchivo)
	{
		try
		{
			TakesScreenshot captura=(TakesScreenshot)driver;
			File archivo=captura.getScreenshotAs(OutputType.FILE);

			File carpeta=new File("Capturas");

			if(!carpeta.exists())
			{
				carpeta.mkdir();
			}

			File destino=new File(carpeta,nombreArchivo + ".png");
			FileUtils.copyFile(archivo, destino);

			System.out.println("Captura Guardada : "+destino.getAbsolutePath());
		}
		catch (IOException e)
		{
			System.out.println("No se pudo guardar la captura "+e.getMessage());
		}
	}

	
	@AfterClass
	public void finPrueba()
	{
		System.out.println("Fin de la prueba");
	}

	@AfterTest
	public void cierreNavegador()
	{
		driver.quit();
	}

	@AfterSuite
	public void finSuite()
	{
		System.out.println("Fin de la suite");
	}







}
