package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import paginas.paginaLogin2;

public class PracticaM4 {
	String url="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account#account-creation";	
	WebDriver driver;
	paginaLogin2 login;

	@BeforeMethod
	public void setUP() {
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@Test(priority=2)
	public void loginUser_Neg() {
		login=new paginaLogin2(driver);
		login.ingresarDatos("test1@gmail.com","123456");
		Assert.assertEquals(login.getTitleForm(), "AUTHENTICATION");

	}
	@Test(priority=1)
	public void loginUser_Pos() {
		login=new paginaLogin2(driver);
		login.ingresarDatos("norvelis.telleria@gmail.com","123456");
		Assert.assertEquals(login.getTitleAccount(), "MY ACCOUNT");
		login.logOut();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}


}