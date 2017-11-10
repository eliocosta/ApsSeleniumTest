package br.edu.utfpr.apsseleniumtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {
    
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8081/");



        // Print a Log In message to the screen
        System.out.println("Opened");

        //Wait for 5 Sec
        Thread.sleep(5000);

        // Close the driver
        driver.quit();
    }
}
