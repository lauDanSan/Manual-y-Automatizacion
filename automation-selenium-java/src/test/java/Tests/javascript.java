package Tests;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class javascript {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:9080/index.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1. Obtener título con JS
        String titulo = (String) js.executeScript("return document.title;");
        System.out.println("Título con JS: " + titulo);

        // 2. Resaltar el botón
        WebElement boton = driver.findElement(By.id("btn"));
        js.executeScript("arguments[0].style.border='3px solid red'", boton);
        Thread.sleep(2000);

        // 3. Hacer scroll hasta el div oculto
        WebElement caja = driver.findElement(By.id("caja"));
        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", caja);
        Thread.sleep(2000);

        // 4. Lanzar un alert desde JS
        js.executeScript("alert('Hola desde Selenium con JS!');");
        Thread.sleep(2000);

        driver.quit();
    }
}