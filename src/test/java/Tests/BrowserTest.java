package Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserTest {

    protected WebDriver driver;
    protected WebDriverWait wait;


    @Before
    public void setUp() {

        WebDriverManager.firefoxdriver().setup();
        //driver = new ChromeDriver(); // в случае, если нужно протестировать в GoogleChrome
        driver = new FirefoxDriver(); // в случае, если нужно протестировать в Firefox
        wait = new WebDriverWait(driver, 10);

    }

    @After
    public void tearDown() {

        driver.quit(); // Закрываем сессию драйвера
    }
}
