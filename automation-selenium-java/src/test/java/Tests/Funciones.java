package Tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Funciones {

    public static void main(String[] args) throws InterruptedException {

// argumentos para controlar el navegador
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-position=400,20"); // controla la posicion de la pantalla x y = x horizontal y vertical
        chromeOptions.addArguments("--window-size=700,700"); // controla el ancho y largo de la pantalla a l = a ancho y l largo
       // chromeOptions.addArguments("--headless"); // se usa si no quiero que abra la ventana del navegador, toma menos tiempo hacer pruebas

        WebDriver driver = new ChromeDriver(chromeOptions); // aca le mando esos argumentos que le estoy dando
        driver.get("https://www.sleepfoundation.org/parasomnias/sleep-paralysis");

        // es un comando para que se maxime la pantalla despues de las indiccaciones anteriores de posicion y tamaño
        driver.manage().window().maximize();

        // No se tiene alguna funcion directa para minimizar entonces lo que se debe hacer es configurara una dimesion
        Dimension dimension = new Dimension(300,280); // yo modifico que valores deseo que tenga la dimension

        // esa dimension se le envia en el comando de setzise
        driver.manage().window().setSize(dimension);

        // funciona para colocarse como pantalla completa
        driver.manage().window().fullscreen();

        String titulo = driver.getTitle();
        System.out.println(titulo);

        // cierra la pestaña de window
        // driver.close();

       // driver.quit();
}


}
