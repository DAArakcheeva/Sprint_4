package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AboutRentPage { // Страница "Про аренду"

    private WebDriver driver;

    private By fieldDate = By.xpath("//input[@placeholder='* Когда привезти самокат']"); // Локатор поля "Когда привезти самокат"
    private By fieldTime= By.className("Dropdown-arrow"); // Локатор стрелки для выпадающего списка поля "Срок аренды"
    private By fieldComment = By.xpath("//input[@placeholder='Комментарий для курьера']"); // Локатор поля для комментария
    private By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Локатор кнопки "Заказать"
    private By yesButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][contains(text(), 'Да')]"); // Локатор кнопки "Да" на плашке "Хотите оформить заказ?"
    private By successOrderButton = By.xpath(".//div[text()='Заказ оформлен']"); // Локатор сообщения об успешном создании заказа


    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDeliveryDate(String validDeliveryDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(1).format(formatter); // Текущая дата + 1 день и форматируем
        driver.findElement(fieldDate).sendKeys(date);
        driver.findElement(fieldDate).sendKeys(Keys.ENTER);
    }



    public void selectFieldTime(String timeField) { // Метод выбирает время аренды

        driver.findElement(fieldTime).click();
        String fieldTimeLocator = String.format(".//div[text()='%s']", timeField);
        driver.findElement(By.xpath(fieldTimeLocator)).click();
    }


    public void selectColour(String colour) { // Метод выбирает цвет самоката
        driver.findElement(By.id(colour)).click();
    }

    public void writeComment(String comment) {
        driver.findElement(fieldComment).sendKeys(comment);
    }

    public void fillRequiredFields(String validDeliveryDate, String timeField, String colour, String comment) {
        enterDeliveryDate(validDeliveryDate);
        selectFieldTime(timeField);
        selectColour(colour);
        writeComment(comment);
    }

    public void clickOrderButton() {

        driver.findElement(orderButton).click();
    }

    public void clickConfirmButton() {

        driver.findElement(yesButton).click();
    }


    public String isExpectedTextButtonSuccess() {
       return driver.findElement(successOrderButton).getText(); // Возвращает текст кнопки
    }

}