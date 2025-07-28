package EducationIT.EduIT_76635;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Try 
{
    String url = "http://www.automationpractice.pl/index.php";

    @Test
    public void registrarUsuario() throws InterruptedException
    {
        WebDriver navegador = null;

        try {
            navegador = new ChromeDriver();
            navegador.manage().deleteAllCookies();
            navegador.manage().window().maximize();
            navegador.get(url);

            WebElement lnkSign = navegador.findElement(By.partialLinkText("Sign"));
            lnkSign.click();

            String MailUsed = "correoXXjul" + Math.random() + "@gmail.com";
            WebElement txtMail = navegador.findElement(By.id("email_create"));
            txtMail.sendKeys(MailUsed);
            System.out.println("Correo usado en el test: " + MailUsed);

            WebElement btnCreate = navegador.findElement(By.name("SubmitCreate"));
            btnCreate.click();

            WebDriverWait espera = new WebDriverWait(navegador, Duration.ofSeconds(10));
            espera.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));

            WebElement btnGender = navegador.findElement(By.id("id_gender1"));
            btnGender.click();

            WebElement txtNombre = navegador.findElement(By.id("customer_firstname"));
            txtNombre.sendKeys("Roger");

            WebElement txtApellido = navegador.findElement(By.cssSelector("#customer_lastname"));
            txtApellido.sendKeys("Rodriguez");

            WebElement txtEmail = navegador.findElement(By.id("email"));
            txtEmail.clear();
            txtEmail.sendKeys(MailUsed);

            String Pass = "correoXXjul" + Math.random();
            WebElement txtPass = navegador.findElement(By.id("passwd"));
            txtPass.sendKeys(Pass);
            System.out.println("Pass usado en el test: " + Pass);

            Select Lstdias = new Select(navegador.findElement(By.id("days")));
            Lstdias.selectByValue("31");

            Select LstMes = new Select(navegador.findElement(By.name("months")));
            LstMes.selectByIndex(12);

            Select LstAño = new Select(navegador.findElement(By.name("years")));
            LstAño.selectByVisibleText("1990  ");

            WebElement chkNews = navegador.findElement(By.name("newsletter"));
            chkNews.click();

            WebElement btnRegistro = navegador.findElement(By.id("submitAccount"));
            btnRegistro.click();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Assertions.fail("Fallo en la prueba: No se encontró algún elemento requerido en el formulario.");
        } finally {
            if (navegador != null) {
                navegador.quit();
            }
        }
    }
}
