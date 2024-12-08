package org.example.Pages;

import org.example.Consts.OrderButton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage { // Главная страница сайта

    private WebDriver driver;

    private By orderButtonUp = By.xpath("//button[@class='Button_Button__ra12g']");  // Локатор кнопки «Заказать» (вверху страницы)
    private By orderButtonDown = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']"); // Локатор кнопки «Заказать» (внизу страницы)

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    public void open() {

        driver.get("https://qa-scooter.praktikum-services.ru");
    }


    public void clickOrderButton(String orderButton) { // Метод кликает по верхней или нижней кнопке заказа самоката

        if (orderButton.equals(OrderButton.BUTTON_UP)) {

            driver.findElement(orderButtonUp).click();

        } else if (orderButton.equals(OrderButton.BUTTON_DOWN)) {

            WebElement lowerOrderButton = driver.findElement(orderButtonDown);
            ((JavascriptExecutor)driver).
                    executeScript("arguments[0].scrollIntoView();", lowerOrderButton); // Скроллим до кнопки

            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(orderButtonDown));
            lowerOrderButton.click();
        }
    }

    public String clickQuestion(int index) {

        By question = By.id(String.format("accordion__heading-%s", index));
        WebElement questionElement = driver.findElement(question);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionElement);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(question));
        questionElement.click();
        return  questionElement.getText();
    }

    public String answerDisplayed(int index) {

        WebElement answerElement = driver.findElement(By.id(String.format("accordion__panel-%s", index)));
        return answerElement.getText();
    }
}