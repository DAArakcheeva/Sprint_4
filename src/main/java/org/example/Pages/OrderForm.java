package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderForm { // Страница "Для кого самокат"

    private WebDriver driver;

    private By fieldName = By.xpath("//input[@placeholder='* Имя']"); // Локатор поля "Имя"
    private By fieldSecondName = By.xpath("//input[@placeholder='* Фамилия']"); // Локатор поля "Фамилия"
    private By fieldAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); // Локатор поля "Адрес"
    private By fieldMetroStation = By.xpath("//input[@placeholder='* Станция метро']"); // Локатор поля "Станция метро"
    private By fieldPhoneNumber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // Локатор поля "Номер телефона"
    private By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Локатор кнопки "Далее"

    public OrderForm (WebDriver driver) {

        this.driver = driver;
    }

    public void setName(String firstName) {

        driver.findElement(fieldName).sendKeys(firstName);
    }

    public void setSurname(String secondName) {

        driver.findElement(fieldSecondName).sendKeys(secondName);
    }

    public void setAddress(String address) {

        driver.findElement(fieldAddress).sendKeys(address);
    }

    public void setPhoneNumber(String phoneNumber) {

        driver.findElement(fieldPhoneNumber).sendKeys(phoneNumber);
    }

    public void chooseMetroStation() {

        driver.findElement(fieldMetroStation).click();
        driver.findElement(fieldMetroStation).sendKeys(Keys.DOWN);
        driver.findElement(fieldMetroStation).sendKeys(Keys.ENTER);
    }

    public void fillAllRequiredFields(String name, String surname, String address, String phoneNumber) {

        setName(name);
        setSurname(surname);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        chooseMetroStation();
    }

    public void clickNextButton() {

        driver.findElement(nextButton).click();
    }
}