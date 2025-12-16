package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Elementos {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-position=400,20"); // controla la posicion de la pantalla x y = x horizontal y vertical
        options.addArguments("--window-size=700,700"); // controla el ancho y largo de la pantalla a l = a ancho y l largo
        options.addArguments("---headless");


        WebDriver driver = new ChromeDriver(options);
        // llama al static_server que se creo a nivel local
        driver.get("http://localhost:9080");

        // como seleccionar elementos a partir de ID = son unicos y solo se espera un resultado

        // estamos seleccionando un elemento web, un elemento web estamos llamando a un elemento id
        WebElement elemento = driver.findElement(By.id("headline"));

        // captura todo el texto que se encuentra dentro de la etiqueta que elegimos anteriormente
        String titulo = elemento.getText();
        System.out.println(titulo);


        // como seleccionar elementos a partir de clases; una clase puede tener varios resultados, ya que las clases se reciclan

        // como son varios el web element debe ser de tipo list y para las listas debemos usar un for each
        List<WebElement> elementos = driver.findElements(By.className("product_title"));

        //WebElement es un objeto que representa un elemento HTML que Selenium encontró en la página
        // aca dice que: Para cada element dentro de la lista elementos, haz lo siguiente".
        //En cada vuelta:
        //Saca un elemento de la lista.
        //Lo guarda en la variable temporal element.
      for (WebElement element : elementos){

        System.out.println(element.getText());


      }

        // como seleccionar por nombre, atributo y etiqueta

          /*By.tagName("h2") → para traer todos los subtítulos.
            By.tagName("p") → para traer todos los párrafos.
            By.tagName("a") → para traer todos los enlaces del menú.
            By.tagName("section") → para ver la información de todas las secciones
            By.tagName("input") → para ver todos los campos de formulario.*/

       List<WebElement> elementos1 = driver.findElements(By.tagName("input")); // el tag name es el nombre de la etiqueta

        for (WebElement elem : elementos1){
            System.out.println(elem.getAttribute("type"));
        }


        /*By.id() con "headline", "btn1", "btn2".
         By.className() con "product_title", "price", "links", "buttons".
         By.tagName("input") para capturar todos los campos del formulario.
         By.tagName("img") para obtener todas las imágenes.
         By.tagName("a") para obtener todos los enlaces.
         By.tagName("button") para los botones.*/

        List<WebElement> elementos2 = driver.findElements(By.tagName("button"));

        for (WebElement e : elementos2){
            System.out.println(e.getText());
        }


        // ejemplo con by.name

        List<WebElement> elementos3 = driver.findElements(By.name("email"));

        for (WebElement w : elementos3){
            System.out.println(w.getAttribute("id"));

        }

        // ejemplos por medio de XPATH

        List<WebElement> elementos4 = driver.findElements(By.xpath("/html/body/section[3]/h2"));

        for (WebElement s : elementos4){
            System.out.println(s.getText());
        }


        // ejemplo de xpath con get cssvalue

        List<WebElement> elements5 = driver.findElements(By.xpath("/html/body/section[3]/h2"));

        for (WebElement t : elements5){
            System.out.println(t.getCssValue( "background-color"));
            System.out.println(t.getCssValue("font-family"));
        }

}

}
