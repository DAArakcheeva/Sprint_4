package Tests;

import org.example.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class OrderFlowTestButtonDown extends Main {

    private By orderButtonDown = By.className("Button_Middle__1CSJM"); // Кнопка «Заказать» (внизу страницы)
    private By fieldName = By.xpath("//input[@placeholder='* Имя']"); // Локатор поля "Имя"
    private By fieldSecondName = By.xpath("//input[@placeholder='* Фамилия']"); // Локатор поля "Фамилия"
    private By fieldAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); // Локатор поля "Адрес"
    private By fieldMetroStation = By.xpath("//input[@placeholder='* Станция метро']"); // Локатор поля "Станция метро"
    private By fieldPhoneNumber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // Локатор поля "Номер телефона"
    private By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Локатор кнопки "Далее"
    private By fieldDate = By.xpath("//input[@placeholder='* Когда привезти самокат']"); // Локатор пола "Когда привезти самокат"
    private By fieldTimeArrow = By.className("Dropdown-arrow"); // Локатор стрелки для выпадающего списка поля "Срок аренды"
    private By fieldTime = By.xpath("//div[text()='четверо суток']"); // Локатор кнопки "четверо суток" из выпадающего списка
    private By fieldColor = By.id("grey"); // Локатор чек-бокса для выбора цвета самоката
    private By fieldComment = By.xpath("//input[@placeholder='Комментарий для курьера']"); // Локатор поля для комментария
    private By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Локатор кнопки "Заказать"
    private By yesButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][contains(text(), 'Да')]"); // Локатор кнопки "Да" на плашке "Хотите оформить заказ?"


    private String name;
    private String surname;
    private String address;
    private String metroStation;
    private String phoneNumber;
    private String date;
    private String comment;

    public OrderFlowTestButtonDown(String name, String surname, String address, String metroStation, String phoneNumber, String date, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.comment = comment;
    }

    @Before

    public void setup() {

        super.setup();
        super.acceptCookies();

        WebElement element = driver.findElement(By.className("Home_FinishButton__1_cWm")); // Прокрутка страницы до нижней кнопки "Заказать"
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);


    }

    @Test
    public void orderFlowTest() {
        driver.findElement(orderButtonDown).click();
        driver.findElement(fieldName).sendKeys(name, Keys.ENTER);
        driver.findElement(fieldSecondName).sendKeys(surname, Keys.ENTER);
        driver.findElement(fieldAddress).sendKeys(address, Keys.ENTER);
        driver.findElement(fieldMetroStation).sendKeys(metroStation, Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(fieldPhoneNumber).sendKeys(phoneNumber, Keys.ENTER);
        driver.findElement(nextButton).click();
        driver.findElement(fieldDate).sendKeys(date, Keys.ENTER);
        driver.findElement(fieldTimeArrow).click();
        driver.findElement(fieldTime).click();
        driver.findElement(fieldColor).click();
        driver.findElement(fieldComment).sendKeys(comment, Keys.ENTER);
        driver.findElement(orderButton).click();

        WebElement orderModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Order_Modal__YZ-d3']")));
        driver.findElement(yesButton).click();

        String expectedTextButtonSuccess = "Посмотреть статус";
        String actualText = driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][contains(text(), 'Посмотреть статус')]")).getText();
        String errorMessage = "Заказ не оформлен!";
        assertEquals(errorMessage, expectedTextButtonSuccess, actualText);
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Иван", "Иванов", "ул. Ленина, д. 25", "Таганская", "+79998887766", "01.02.2023", "Первый комментарий"},
                {"Петр", "Петров", "пр-т Мира, д. 50", "Белорусская", "+71234567890", "15.03.2023", "Второй комментарий"},
                {"Анна", "Сидорова", "ул. Тверская, д. 100", "Кузнецкий мост", "+79876543211", "20.04.2023", "Третий комментарий"}
        };
    }


    @After
    public void tearDown() {
        super.teardown();
    }
}