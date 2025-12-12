package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

public class form {

    public static void main (String[] args) throws InterruptedException{



        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, 300)");
        Thread.sleep(2000);

        WebElement form1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div[3]/h5"));
        form1.click();
        Thread.sleep(2000);

        WebElement form2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[2]/div"));
        form2.click();
        Thread.sleep(2000);

        // esto es para hacer scroll por medio de java script
        js.executeScript("window.scrollTo(0,300)");

        // estos son para ingresar informacion en inputs entonces no se necesita crear una variable ya que solo voy a hacer una tarea
        // en caso de que si vaya a hacer varias tareas debo crear una variable  WebElement boton2 = driver.findElement(By.id("enviarBtn"));
        // cuando no haya propiedad id, se debe usar el name

        driver.findElement(By.id("firstName")).sendKeys("Laura");
        driver.findElement(By.id("lastName")).sendKeys("cleopatra");
        driver.findElement(By.id("userEmail")).sendKeys("cleopatra@lau.com");

        // estos es para los radiobuttons, permiten elegir una de multiples opciones, es decir siempre solo sera una opcion

        Thread.sleep(2000);

        // El <label> se usa para asociar un texto o área clickeable a un campo de formulario (como un radio, checkbox o input).
        //Es decir: el usuario no hace clic directamente sobre el control (que a veces está oculto o estilizado), sino sobre el label.

       // el label es la forma del radio button, es suficiente darle clic al label, ahi mismo se selecciona el input del radio button
        driver.findElement(By.cssSelector("label[for='gender-radio-3']")).click();

        driver.findElement(By.id("userNumber")).sendKeys("3213453255");

        // si el input del radio button no esta dentro del label seria de la siguiente forma:
        // driver.findElement(By.id("gender-radio-2")).click();

        js.executeScript("window.scrollTo(0,400)");

        driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]")).click();


        js.executeScript("window.scrollTo(0,700)");


        //controles de tipo select
        // esto se usa para los que son de tipo select
       /* Select topic = new Select(driver.findElement(By.id("state")));

        Thread.sleep(2000);

        topic.selectByVisibleText("NCR");

        */

        // esto para los que son de tipo div (select falsos)
        //
        //Click en el campo para desplegar las opciones cuando se utilizo un div
        driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'NCR')]")));

        driver.findElement(By.xpath("//div[contains(text(),'NCR')]")).click();


        //Click en el campo para desplegar las opciones cuando se utilizo un div
        driver.findElement(By.xpath("//*[@id=\"city\"]")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Delhi')]")));

        driver.findElement(By.xpath("//div[contains(text(),'Delhi')]")).click();


        Thread.sleep(2000);

        js.executeScript("window.scrollTo(0,400)");

        // el label es la forma del check box es suficiente darle clic al label, ahi mismo se selecciona el input del check box

      /*  driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']")).click();*/

        // esta seria una forma de hacerlo con un controlador logico usando el ID del check box

        WebElement condicion =  driver.findElement(By.id("hobbies-checkbox-1"));

        Thread.sleep(2000);

        if( !condicion.isSelected()){
            condicion.sendKeys(Keys.SPACE);
        }

        // como escribir en un campo de texto que no es de tipo input, si no que es un div

        driver.findElement(By.id("subjectsInput")).sendKeys("En");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'English')]")));

        driver.findElement(By.xpath("//div[contains(text(),'English')]")).click();


        Thread.sleep(5000);

        js.executeScript("window.scrollTo(0,700)");

        //Hay dos forma de dar submit a un formulario, ya sea por medio del id del botón de submit o invocando el id del formulario en general y enviando .submit()

        //driver.findElement(By.id("submit")).click();

        driver.findElement(By.id("userForm")).submit();


        // lo que se hace aca es maximizar la pantalla
        driver.manage().window().maximize();


        //🔹 1️⃣ File src = driver.getScreenshotAs(OutputType.FILE);
        //
        //driver es tu instancia de WebDriver (por ejemplo, ChromeDriver).
        //
        //El método getScreenshotAs() le dice al navegador:
        //
        //“Toma una captura de pantalla de la ventana actual.”
        //
        //OutputType.FILE significa que queremos que el resultado sea un archivo (File

        File src = driver.getScreenshotAs (OutputType.FILE);


        // con esto se genera un nombre aleatorio unico

        String filename = "screenshot" + UUID.randomUUID() + ".png";

        //Lo que hace es copiar el archivo temporal (src) hacia una ruta permanente que tú le indiques

        try{
            FileUtils.copyFile(src, new File("C:/selenium/" + filename));
        }

            catch (IOException e) {
           System.out.println(e.getMessage());
        }

        Thread.sleep(5000);


        driver.quit();
    }

}
