package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class OrderFlowFirefox {

    private WebDriver driver;
    private WebDriverWait wait;

    private By orderButtonUp = By.xpath("//button[@class='Button_Button__ra12g']"); // Локатор кнопки "Заказать" вверху страницы
    private By fieldName = By.xpath("//input[@placeholder='* Имя']"); // Локатор поля "Имя"
    private By fieldSecondName = By.xpath("//input[@placeholder='* Фамилия']"); // Локатор поля "Фамилия"
    private By fieldAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); // Локатор поля "Адрес"
    private By fieldMetroStation = By.xpath("//input[@placeholder='* Станция метро']"); // Локатор поля "Станция метро"
    private By fieldPhoneNumber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // Локатор поля "Номер телефона"
    private By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Локатор кнопки "Далее"
    private By fieldDate = By.xpath("//input[@placeholder='* Когда привезти самокат']"); // Локатор поля "Когда привезти самокат"
    private By fieldTimeArrow = By.className("Dropdown-arrow"); // Локатор стрелки для выпадающего списка поля "Срок аренды"
    private By fieldTime = By.xpath("//div[text()='четверо суток']"); // Локатор кнопки "четверо суток" из выпадающего списка
    private By fieldColor = By.id("grey"); // Локатор чек-бокса для выбора цвета самоката
    private By fieldComment = By.xpath("//input[@placeholder='Комментарий для курьера']"); // Локатор поля для комментария
    private By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); // Локатор кнопки "Заказать"
    private By yesButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][contains(text(), 'Да')]"); // Локатор кнопки "Да" на плашке "Хотите оформить заказ?"

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\bin\\geckodriver.exe");
        driver = new FirefoxDriver(); // Инициализируем драйвер
        wait = new WebDriverWait(driver, 10);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(By.xpath("//button[@class='App_CookieButton__3cvqF']")).click();
    }

    @Test
    public void orderFlowTest() {
        driver.findElement(orderButtonUp).click();
        driver.findElement(fieldName).sendKeys("Иван", Keys.ENTER);
        driver.findElement(fieldSecondName).sendKeys("Иванов", Keys.ENTER);
        driver.findElement(fieldAddress).sendKeys("Ленинский проспект д.5 кв.3", Keys.ENTER);
        driver.findElement(fieldMetroStation).sendKeys("Октябрьская", Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(fieldPhoneNumber).sendKeys("1111111111111", Keys.ENTER);
        driver.findElement(nextButton).click();
        driver.findElement(fieldDate).sendKeys("12.12.2024", Keys.ENTER);
        driver.findElement(fieldTimeArrow).click();
        driver.findElement(fieldTime).click();
        driver.findElement(fieldColor).click();
        driver.findElement(fieldComment).sendKeys("Пожалуйста, спасибо :)", Keys.ENTER);
        driver.findElement(orderButton).click();

        WebElement orderModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Order_Modal__YZ-d3']")));
        driver.findElement(yesButton).click();

        String expectedTextButtonSuccess = "Посмотреть статус";
        String actualText = driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][contains(text(), 'Посмотреть статус')]")).getText();
        String errorMessage = "Заказ не оформлен!";
        assertEquals(errorMessage, expectedTextButtonSuccess, actualText);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}