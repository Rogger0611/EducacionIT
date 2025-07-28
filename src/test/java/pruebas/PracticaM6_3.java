package pruebas;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticaM6_3 {
	String Url="https://demo.guru99.com/test/upload/";
	WebDriver driver;
	
	@BeforeMethod
	public void setUP() {
		
		driver= new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
    @Test
	public void testAlert() {
		WebElement rutaArchivo=driver.findElement(By.id("uploadfile_0"));
	    rutaArchivo.sendKeys("C:\\Users\\rogge\\Documents\\prueba.txt");
		
	}
	
	@AfterMethod
    public void tearDown() {
    	
    	driver.quit();
		
	}
}
	