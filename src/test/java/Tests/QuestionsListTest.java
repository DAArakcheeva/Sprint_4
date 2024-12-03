package Tests;

import org.example.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class QuestionsListTest extends Main {


    private By firstQuestion = By.xpath("//div[contains(@id, 'accordion__heading-0')][contains(text(), 'Сколько это стоит? И как оплатить?')]");
    private By firstAnswer = By.xpath("//div[@id='accordion__panel-0']");
    private By secondQuestion = By.xpath("//div[contains(@id, 'accordion__heading-1')][contains(text(), 'Хочу сразу несколько самокатов! Так можно?')]");
    private By secondAnswer = By.xpath("//div[@id='accordion__panel-1']");
    private By thirdQuestion = By.xpath("//div[contains(@id, 'accordion__heading-2')][contains(text(), 'Как рассчитывается время аренды?')]");
    private By thirdAnswer = By.xpath("//div[@id='accordion__panel-2']");
    private By fourthQuestion = By.xpath("//div[contains(@id, 'accordion__heading-3')][contains(text(), 'Можно ли заказать самокат прямо на сегодня?')]");
    private By fourthAnswer = By.xpath("//div[@id='accordion__panel-3']");
    private By fifthQuestion = By.xpath("//div[contains(@id, 'accordion__heading-4')][contains(text(), 'Можно ли продлить заказ или вернуть самокат раньше?')]");
    private By fifthAnswer = By.xpath("//div[@id='accordion__panel-4']");
    private By sixthQuestion = By.xpath("//div[contains(@id, 'accordion__heading-5')][contains(text(), 'Вы привозите зарядку вместе с самокатом?')]");
    private By sixthAnswer = By.xpath("//div[@id='accordion__panel-5']");
    private By seventhQuestion = By.xpath("//div[contains(@id, 'accordion__heading-6')][contains(text(), 'Можно ли отменить заказ?')]");
    private By seventhAnswer = By.xpath("//div[@id='accordion__panel-6']");
    private By eighthQuestion = By.xpath("//div[contains(@id, 'accordion__heading-7')][contains(text(), 'Я жизу за МКАДом, привезёте?')]");
    private By eighthAnswer = By.xpath("//div[@id='accordion__panel-7']");

    @Before

    public void setup() {

        super.setup();
        super.acceptCookies();

        WebElement element = driver.findElement(By.xpath("//div[@class='Home_SubHeader__zwi_E'][contains(text(), 'Вопросы о важном')]")); // Прокрутка страницы до блока "Вопросы о важном"
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    @Test

    public void checkTextAnswer() { // метод проверяет текст ответов

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(firstQuestion));

        driver.findElement(firstQuestion).click();

        String expectedTextAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actualTextAnswer = driver.findElement(firstAnswer).getText();
        String errorMessageAnswer = "Текст ответа на первый вопрос не совпадает с ожидаемым.";
        assertEquals(errorMessageAnswer, expectedTextAnswer, actualTextAnswer);

        driver.findElement(secondQuestion).click();

        String expectedTextAnswer2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actualTextAnswer2 = driver.findElement(secondAnswer).getText();
        String errorMessageAnswer2 = "Текст ответа на второй вопрос не совпадает с ожидаемым.";
        assertEquals(errorMessageAnswer2, expectedTextAnswer2, actualTextAnswer2);

        driver.findElement(thirdQuestion).click();

        String expectedTextAnswer3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String actualTextAnswer3 = driver.findElement(thirdAnswer).getText();
        String errorMessageAnswer3 = "Текст ответа на третий вопрос не совпадает с ожидаемым.";
        assertEquals(errorMessageAnswer3, expectedTextAnswer3, actualTextAnswer3);

        driver.findElement(fourthQuestion).click();

        String expectedTextAnswer4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actualTextAnswer4 = driver.findElement(fourthAnswer).getText();
        String errorMessageAnswer4 = "Текст ответа на четвертый вопрос не совпадает с ожидаемым.";
        assertEquals(errorMessageAnswer4, expectedTextAnswer4, actualTextAnswer4);

        driver.findElement(fifthQuestion).click();

        String expectedTextAnswer5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String actualTextAnswer5 = driver.findElement(fifthAnswer).getText();
        String errorMessageAnswer5 = "Текст ответа на пятый вопрос не совпадает с ожидаемым.";
        assertEquals(errorMessageAnswer5, expectedTextAnswer5, actualTextAnswer5);

        driver.findElement(sixthQuestion).click();

        String expectedTextAnswer6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String actualTextAnswer6 = driver.findElement(sixthAnswer).getText();
        String errorMessageAnswer6 = "Текст ответа на шестой вопрос не совпадает с ожидаемым.";
        assertEquals(errorMessageAnswer6, expectedTextAnswer6, actualTextAnswer6);

        driver.findElement(seventhQuestion).click();

        String expectedTextAnswer7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String actualTextAnswer7 = driver.findElement(seventhAnswer).getText();
        String errorMessageAnswer7 = "Текст ответа на седьмой вопрос не совпадает с ожидаемым.";
        assertEquals(errorMessageAnswer7, expectedTextAnswer7, actualTextAnswer7);

        driver.findElement(eighthQuestion).click();

        String expectedTextAnswer8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actualTextAnswer8 = driver.findElement(eighthAnswer).getText();
        String errorMessageAnswer8 = "Текст ответа на восьмой вопрос не совпадает с ожидаемым.";
        assertEquals(errorMessageAnswer8, expectedTextAnswer8, actualTextAnswer8);

    }

    @After
    public void tearDown() {
        super.teardown();
    }
}


    /* // Массив с ожидаемыми текстами вопросов
    private final String[] EXPECTED_QUESTIONS = {
            "Сколько это стоит? И как оплатить?",
            "Хочу сразу несколько самокатов! Так можно?",
            "Как рассчитывается время аренды?",
            "Можно ли заказать самокат прямо на сегодня?",
            "Можно ли продлить заказ или вернуть самокат раньше?",
            "Вы привозите зарядку вместе с самокатом?",
            "Можно ли отменить заказ?",
            "Я жизу за МКАДом, привезёте?"
    };

    // Массив с ожидаемыми текстами ответов
    private final String[] EXPECTED_ANSWERS = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    }; */
