package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest 
{
	WebDriver driver=null;
	String url="http://www.automationpractice.pl/index.php";
	By searchqueryLocator=By.cssSelector("input[placeholder='Search']");
	
	@BeforeMethod
	@Parameters({"navegador"})
	public void setUP(@Optional("navegador")String navegador)
	{
		if(navegador.equalsIgnoreCase("Firefox"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void buscar()
	{
		WebElement txtBusqueda=driver.findElement(searchqueryLocator);
		WebElement btnBusqueda=driver.findElement(By.name("submit_search"));
		txtBusqueda.sendKeys("dress");
		btnBusqueda.click();
		driver.quit();
		
	}
}
