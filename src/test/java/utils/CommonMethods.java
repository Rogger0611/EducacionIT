package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
public class CommonMethods {
	  WebDriver driver;
	    WebDriverWait wait;

	    public CommonMethods(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    public void escribirTexto(By locator, String texto) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
	        driver.findElement(locator).sendKeys(texto);
	    }

	    public void hacerClick(By locator) {
	        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	    }

	    public String obtenerTexto(By locator) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	    }

	    public boolean estaPresente(By locator) {
	        return driver.findElements(locator).size() > 0;
	    }

}