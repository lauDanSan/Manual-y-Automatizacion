package Tests;

import com.miempresa.saucedemo.LoginPage;
import com.miempresa.saucedemo.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests {
    public static void main(String[] args) throws InterruptedException {
        try {
        // Abrir navegador
        WebDriver driver = new ChromeDriver();

        // Ir a la página
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // Usar la clase LoginPage
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Espera para ver el resultado (solo demostración)
        Thread.sleep(3000);

        // Cerrar navegador
        driver.quit();
        }catch (Exception e){
          //  System.out.println(e); //muestra el error y en que parte esta
           System.out.println("error en el codigo, algo salio mal"); // solo muestra el texto que estan entre comillas
           throw e; // muestra el error
        }
    }
}