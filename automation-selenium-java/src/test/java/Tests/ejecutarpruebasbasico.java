package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ejecutarpruebasbasico {

    @Test (priority = 2, description = "es un flujo high")
    void pruebainicial(){
        System.out.println("prueba uno correcta");
        Assert.assertEquals("uno" , "dos");
    }

    @Test (priority = 3, description = "es un flujo medium")
    void pruebados(){
        System.out.println("prueba dos correcta");
        Assert.assertEquals("dos", "dos");
    }

    @Test (priority = 1, description = "es un flujo critico")
    void pruebacompleta(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-position=0,70");
        options.addArguments("--window-size=700,600");

        WebDriver driver = new ChromeDriver(options);

        driver.get("http://localhost:9080/");

        Assert.assertEquals(driver.getTitle(),"Lupe y Pili resturant");
    }

    // entre menor numero tiene de prioridad, es mas alta la prioridad

}
