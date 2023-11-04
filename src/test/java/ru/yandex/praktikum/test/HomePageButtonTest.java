package ru.yandex.praktikum.test;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.AfterMethod;
import ru.yandex.praktikum.main.MainPage;
import ru.yandex.praktikum.main.OrderPage;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HomePageButtonTest {

    private static WebDriver driver;
    private static MainPage mainPage;
    private OrderPage orderPage;
    private final int indexButton = 1;

    @BeforeClass
    public static void initialOrder() {

        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver = new Augmenter().augment(driver);
    }
     @Test
    public void testOpen() {

        driver.get(FaqTest.SCOOTER_URL);
        mainPage = new MainPage(driver);
        mainPage.waitForLoadPage();
        mainPage.clickGetCookie();

        mainPage.clickOrder(indexButton);
        orderPage = new OrderPage(driver);
        orderPage.waitForLoadOrderPage();

        assertTrue("Форма ввода данных не открыта", mainPage.isElementExist(orderPage.orderHeader));
    }

    @AfterClass
    public static void tearDown() {
        if (driver!=null)
            driver.quit();
    }
    @AfterMethod
    public void afterEachTest() {
        // Дополнительные действия после каждого теста, если необходимо
        // Например, добавление скриншотов или запись результатов в отчет
    }
}