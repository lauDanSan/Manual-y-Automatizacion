package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


    public class Principal {
        public static void main(String[] args) throws InterruptedException {
            // Si no está en el PATH, agrega la ruta así:
            // System.setProperty("webdriver.chrome.driver", "C:\\ruta\\a\\chromedriver.exe");

            WebDriver driver1 = new ChromeDriver();
            driver1.get("https://www.sleepfoundation.org/parasomnias/sleep-paralysis");
            String titulo1 = driver1.getTitle();
            Thread.sleep(3000); // Espera 3 segundos
            System.out.println("Título de la página: " + titulo1);
            driver1.quit();

            WebDriver driver2 = new ChromeDriver();
            driver2.get("https://www.canva.com/design/DAGlT2vuR-4/-0MJayhLQlCISgh1fwlVew/edit");
            String titulo2 = driver2.getTitle();
            Thread.sleep(3000); // Espera 3 segundos
            System.out.println("Título de la página: " + titulo2);
            driver2.quit();

            WebDriver driver3 = new FirefoxDriver();
            driver3.get("https://es.wikipedia.org/wiki/Wiki");
            String titulo3 = driver3.getTitle();
            System.out.println("Título de la página: " + titulo3);
            driver3.quit();

            WebDriver driver4 = new EdgeDriver();
            driver4.get("https://www.cambridgeenglish.org/es/");
            String titulo4 = driver1.getTitle();
            Thread.sleep(3000);
            System.out.println("Título de la página: " + titulo4);
            driver4.quit();


        }

    }


