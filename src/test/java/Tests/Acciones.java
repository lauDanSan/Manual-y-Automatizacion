package Tests;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Acciones {

    public static void main (String[] args) throws InterruptedException {

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--window-position=100,20");
        option.addArguments("--window-size=1300,700");
      //  option.addArguments("---headless");

        WebDriver driver = new ChromeDriver(option);
        driver.get("http://localhost:9080");

        // Simular un evento clic en un elemento web
        // id="enviarBtn"
        // dentro de la pagina web encuentreme cualquier id que sea enviarBtn // recordar que los id son unicos

        WebElement boton = driver.findElement(By.id("enviarBtn"));

        // simular clic
        boton.click();

        Alert mensaje = driver.switchTo().alert(); // cambia la atencion del diver en el pop up
        System.out.println(mensaje.getText()); // saca el texto visualizado en el pop up

        mensaje.accept(); // cierra la alerta

/*  // aca estoy intentando aprender como hago scroll primera opcion

        // Importante: importar JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Desplazar hacia abajo 500 píxeles
        js.executeScript("window.scrollBy(0, 200)"); */

/*   // aca estoy intentando aprender como hago scroll segunda opcion

        WebElement scroll = driver.findElement(By.id("imagenPrueba"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", scroll);
*/


        // simular un movimiento del mouse a traves de la pantalla
        // id="imagenPrueba"

        WebElement movermouse = driver.findElement(By.id("imagenPrueba"));

        // con esto simulamos eso de mover el mouse, por medio de Actions que nos permite crear acciones del mouse

        Actions accion = new Actions(driver);

        accion.moveToElement(movermouse).build().perform(); // lo que hace aca, es que toma esa accion y la ejecuta

        // aca lo que hace es que selenium deje de ponerle atencion a la ventan principal y se enfoque en el pop up
        // switch to, es cambie a

        Alert alertanew = driver.switchTo().alert();
        System.out.println(alertanew.getText());

        mensaje.accept();



        // hacer que cuando se presione una tecla del teclado se muestre un pop up

        WebElement teclado = driver.findElement(By.tagName("body")); // el tag name body tiene todo el html por dentro

        teclado.sendKeys(Keys.ENTER); // el keys.  es para una sola tecla en especifico

        Alert alerteclado = driver.switchTo().alert(); // aca ya cambiamos el foco hacia la alerta

        System.out.println(alerteclado.getText());

        alerteclado.accept();




// Deteccion de cambios en el URL

        WebElement enlance = driver.findElement(By.xpath("/html/body/section[3]/ul/li[1]/a"));

        String oldenlance = driver.getCurrentUrl();

        enlance.click();

        System.out.println("este es el enlance viejo  " + oldenlance);

        Thread.sleep(3000);

        String newenlance = driver.getCurrentUrl();

if (oldenlance.equals(newenlance)){
    System.out.println("Error en la navegación");
}
else{
    System.out.println("Navegacion correcta");
}
        System.out.println("Este es el enlance nuevo  " + newenlance);


      // Capturar el titulo en el head

        System.out.println(driver.getTitle());

        driver.get("http://localhost:9080/");

        System.out.println(driver.getTitle());

        // Navegaciòn en URLs con navigate que accede al historial

        driver.navigate().to("http://localhost:9080/");  // el to indica que vaya hacia esa url

        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("https://es.wikipedia.org/wiki/Wiki"); // el to indica que vaya hacia esa url

        System.out.println(driver.getCurrentUrl());

        driver.navigate().back(); // con back vamos hacia lo anterior que estabamos visualizando

        System.out.println(driver.getCurrentUrl());

        Thread.sleep(3000);

// como realizar combinaciones con diferentes teclas ya sea para abir enlaces, para guardar imagenes

        /*

        Atajos como CTRL + F, CTRL + H, CTRL + T no funcionan en Selenium, porque son propios del navegador, no del sitio.

Selenium sí puede enviar combinaciones de teclas dentro de inputs, formularios o campos de texto, y ahí sí verás el efecto.
         */


        /*
        Ese <div> no es editable ni un campo de entrada (<input> o <textarea>). Por eso Selenium dice ElementNotInteractableException,
        porque a un div no le puedes mandar teclas como CTRL+A., se puede usar body, input
        */
        driver.get("https://practice.automationtesting.in/test-cases/");

      //  driver.manage().window().fullscreen();

        String operacionteclado = Keys.chord(Keys.CONTROL,"a"); // el keys.chord es para una combinacion de teclas

        WebElement operacion = driver.findElement(By.tagName("body"));

     ///   operacion.click();

        Thread.sleep(1000);

        operacion.sendKeys(operacionteclado);


        Thread.sleep(1000);

        WebElement operacion2 = driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a"));

        Actions newaction = new Actions(driver);

        // Explicación detallada
        //
        //keyDown(Keys.CONTROL)
        //Simula que el usuario mantiene presionada la tecla Ctrl en el teclado.
        //Es como si lo hicieras manualmente con tu dedo.
        //
        //.click(operacion2)
        //Hace un clic izquierdo sobre el WebElement que le indicaste (en este caso, el enlace Shop).
        //Como la tecla Ctrl sigue "presionada", el clic equivale a Ctrl + Clic.
        //→ Esto en la mayoría de navegadores abre el enlace en una nueva pestaña.
        //
        //.keyUp(Keys.CONTROL)
        //Simula soltar la tecla Ctrl.
        //(Es importante “liberar” la tecla, para que Selenium no piense que sigue presionada en pasos futuros).
        //
        //.build()
        //Construye toda la secuencia de acciones (Ctrl presionado → clic → soltar Ctrl).
        //Esto devuelve un objeto Action listo para ejecutarse.
        //
        //.perform()
        //Finalmente, ejecuta la acción sobre el navegador.
        
        newaction.keyDown(Keys.CONTROL).click(operacion2).keyUp(Keys.CONTROL).build().perform();

        //  ¿por qué se debe utilizar un array?
        //  Porque es un esquema que te permite guardar datos para luego acceder a ellos de forma sencilla


        // driver.getWindowHandles() ---> devuelve el id de todas las ventanas
        // driver.getWindowHandle() --->devuelve el id de la ventana actual
        // devuelve un conjunto (Set<String>) con los ID únicos de todas las ventanas/pestañas que están abiertas en ese momento en el navegador.
        //Cada ventana o pestaña tiene un Window Handle (una especie de "identificador") que Selenium usa para poder controlarla.

        System.out.println("el identificador es " + driver.getWindowHandles());


        ArrayList tabs = new ArrayList(driver.getWindowHandles()); // esto nos va a decir la cantidad de tabs que tenemos


        System.out.println("esta es la cantidad de ventanas que hay " + tabs.size());

        System.out.println("ventana 1 " + driver.getCurrentUrl());

        // aca lo que vamos a hacer es que se va a cambiar de un tab a otro, es decir de una pestaña a otra
        // driver cambie a la ventana, le estoy mandando la posicion el el array, el array comienza desde la posicion 0
        driver.switchTo().window(tabs.get(1).toString());

        System.out.println("ventana 2 " + driver.getCurrentUrl());



        // aca lo que harè es mirar una nueva pàntalla


        driver.get("http://localhost:9080/");

        System.out.println("ventana lupe y pili " + driver.getCurrentUrl());

        WebElement otraventana = driver.findElement(By.xpath("/html/body/section[3]/ul/li[4]/a"));

        otraventana.click();


        ArrayList otra = new ArrayList(driver.getWindowHandles());

        System.out.println("esta es la cantidad de ventanas que hay" + otra.size());

        driver.switchTo().window(otra.get(2).toString());

        System.out.println("ventana google " + driver.getCurrentUrl());

        driver.get("http://localhost:9080/");



      // ejecutar comandos javascript desde selenium
        //Es una funcionalidad muy útil cuando lo que Selenium “normal” no alcanza a hacer,
        // o necesitas hacer algo directamente en la página con JS.
        //Por qué ejecutar JS desde Selenium?
        //Algunas cosas que Selenium no puede controlar directamente con sus métodos API normales:
        //Leer o modificar valores de propiedades JS que no tienen “API” expuestas.
        //Ejecutar scripts que hagan transformaciones complejas en el DOM.
        //Hacer scroll suave o animaciones, o escuchar eventos particulares.
        //Interactuar con páginas muy dinámicas donde el JS de la página gestiona mucho del comportamiento


        //En Selenium WebDriver, existe una interfaz llamada JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Una vez tienes el js, puedes usar:
        //js.executeScript(String script, Object... args) → Ejecuta script JS sin retorno o que devuelve algo sincrónico.
        //js.executeAsyncScript(String script, Object... args) → Para scripts asíncronos que usan callback para terminar.


        // Resaltar el botón
        WebElement boton2 = driver.findElement(By.id("enviarBtn"));
        js.executeScript("arguments[0].style.border='3px solid red'", boton2);
        Thread.sleep(2000);

        // Hacer scroll hacia abajo:
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);

        // Ejecutar un alert:
        js.executeScript("alert('Hola desde JS en Selenium')");
        Thread.sleep(5000);
















    }
}
