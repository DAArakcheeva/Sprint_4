package Tests;

import org.example.Consts.OrderButton;
import org.example.Pages.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class OrderFlowTest extends BrowserTest {

    private final String orderButton; // Кнопка заказа (верхняя или нижняя)
    private final String name; // Имя
    private final String surname; // Фамилия
    private final String address; // Адрес доставки
    private final String phoneNumber; // Номер телефона
    private final String validDeliveryDate; // Дата аренды
    private final String rentalPeriod; // Период аренды
    private final String colour; // Цвет самоката
    private final String comment; // Комментарий
    private boolean actual; // Ожидаемый результат

    public OrderFlowTest(String orderButton, String name, String surname, String address,
                         String phoneNumber, String validDeliveryDate, String rentalPeriod, String colour, String comment) {

        this.orderButton = orderButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.validDeliveryDate = validDeliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.colour = colour;
        this.comment = comment;

    }

    @Parameterized.Parameters
    public static Object[][] getOrderFormData() {
        return new Object[][] {

                { OrderButton.BUTTON_UP, "Мальвина", "Тестовна", "Огромная Москва",
                        "81111111111", "08.12.2024", "двое суток", "black", "Первый коммент" },
                { OrderButton.BUTTON_DOWN, "Пьеро", "Тестович", "Перово, дом 666 квартира 6666",
                        "+7111111111", "08.12.2024", "семеро суток", "grey", "Второй коммент"},

        };
    }

    @Test
    public void orderFlowTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOrderButton(orderButton);

        OrderForm orderForm = new OrderForm(driver);
        orderForm.fillAllRequiredFields(name, surname, address, phoneNumber);
        orderForm.clickNextButton();

        AboutRentPage aboutrentPage = new AboutRentPage(driver);
        aboutrentPage.fillRequiredFields(validDeliveryDate, rentalPeriod, colour, comment);
        aboutrentPage.clickOrderButton();

        aboutrentPage.clickConfirmButton();

        String expectedTextButtonSuccess = "Посмотреть статус";
        String actualText = driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][contains(text(), 'Посмотреть статус')]")).getText();
        String errorMessage = "Заказ не оформлен!";
        assertEquals(errorMessage, expectedTextButtonSuccess, actualText);

    }
}
