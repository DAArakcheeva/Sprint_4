package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Main {

    protected WebDriver driver;
    protected WebDriverWait wait;



    public static void main(String[] args) {
        Main app = new Main();
        app.setup();// Вызываем метод setupBeforeTest для инициализации драйвера и открытия URL
        app.acceptCookies();   // Вызываем метод для нажатия на кнопку с куки
    }


    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        driver = new ChromeDriver(); // Инициализируем драйвер
        wait = new WebDriverWait(driver, 10);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void acceptCookies() {
        driver.findElement(By.xpath("//button[@class='App_CookieButton__3cvqF']")).click(); // Нажатие по кнопке с куки
    }

    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}