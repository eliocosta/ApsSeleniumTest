package br.edu.utfpr.apsseleniumtest;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClass {
    
    public static boolean TestFormulario() throws InterruptedException{
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8080/");
        
        driver.findElement(By.name("nome")).sendKeys("Elio");
        driver.findElement(By.name("endereco")).sendKeys("Avenida Brasil");
        driver.findElement(By.name("telefone")).sendKeys("46999392238");
        driver.findElement(By.name("submit")).submit();
        
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                  .until(ExpectedConditions.presenceOfElementLocated(By.id("box-result")));
        
        WebElement element = driver.findElement(By.id("box-result"));
        
        System.out.println("----------");
        System.out.println("Retorno do teste: " + element.getText());
        System.out.println("----------");
        
        Thread.sleep(2000);
        driver.quit();
        return true;
    }
    
    public static boolean TesteGoogleSeach() throws InterruptedException{
        
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!\n"); // send also a "\n"
        element.submit();

        // wait until the google page shows the result
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                  .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

        List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

        // this are all the links you like to visit
        for (WebElement webElement : findElements)
        {
            System.out.println(webElement.getAttribute("href"));
        }
        
//        Wait for 5 Sec
        Thread.sleep(2000);
        
        driver.quit();
        return true;
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        TestFormulario();
        TesteGoogleSeach();
    }
}
