package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.OnlinePaymentPage;
import pages.PaymentPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Проверка блока Онлайн пополнение без комиссии")
public class MtsByTests {

    private WebDriver driver;
    private OnlinePaymentPage paymentPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.acceptCookies();
        paymentPage = mainPage.goToOnlinePaymentBlock();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("1. Название блока соответствует ожидаемому")
    public void testBlockTitle() {
        String title = paymentPage.getBlockTitle();
        System.out.println("Заголовок блока: " + title);

        String normalized = title.replaceAll("\\s+", " ").trim().toLowerCase();

        assertAll("Заголовок блока",
                () -> assertFalse(title.isEmpty(),
                        "Заголовок блока пустой"),
                () -> assertTrue(normalized.contains("онлайн пополнение без комиссии"),
                        "Ожидали текст «Онлайн пополнение без комиссии», а получили: " + title)
        );
    }

    @Test
    @DisplayName("2. На странице 5 логотипов платёжных систем и все они видны")
    public void testLogos() {
        List<WebElement> logoElements = paymentPage.getLogos();

        assertEquals(5, logoElements.size(),
                "Ожидали 5 логотипов, а нашли: " + logoElements.size());

        assertAll("Логотипы платёжных систем",
                () -> assertTrue(paymentPage.isLogoVisible("Visa"),
                        "Логотип Visa не найден или не виден"),
                () -> assertTrue(paymentPage.isLogoVisible("Verified By Visa"),
                        "Логотип Verified By Visa не найден или не виден"),
                () -> assertTrue(paymentPage.isLogoVisible("MasterCard"),
                        "Логотип MasterCard не найден или не виден"),
                () -> assertTrue(paymentPage.isLogoVisible("MasterCard Secure Code"),
                        "Логотип MasterCard Secure Code не найден или не виден"),
                () -> assertTrue(paymentPage.isLogoVisible("Белкарт"),
                        "Логотип Белкарт не найден или не виден")
        );
    }

    @Test
    @DisplayName("3. Ссылка Подробнее о сервисе открывает нужную страницу")
    public void testDetailsLink() {
        String expectedUrl =
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        paymentPage.clickDetailsLink();

        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();

        assertAll("Страница Подробнее о сервисе",
                () -> assertEquals(expectedUrl, currentUrl,
                        "URL страницы Подробнее о сервисе не совпадает"),
                () -> assertTrue(title.contains("Порядок оплаты и безопасность интернет платежей"),
                        "Заголовок страницы не совпадает: " + title)
        );
    }

    @Test
    @DisplayName("4. Кнопка «Продолжить» открывает iframe с верными телефоном и суммой")
    public void testContinueButton() {

        assertEquals("Услуги связи", paymentPage.getSelectedServiceText(),
                "По умолчанию должен быть выбран вариант Услуги связи");

        String phone = "297777777";
        String sum = "10";
        paymentPage.enterPhone(phone);
        paymentPage.enterSum(sum);

        paymentPage.clickContinue();

        PaymentPage payPage = new PaymentPage(driver);
        assertTrue(payPage.isOpened(), "iframe оплаты не открылся");

        String description = payPage.getDescription();
        String cost = payPage.getCost();

        assertAll("Данные в iframe оплаты",
                () -> assertTrue(description.contains("Оплата: Услуги связи"),
                        "В описании нет Оплата: Услуги связи. Получили: " + description),
                () -> assertTrue(description.contains(phone),
                        "В описании нет номера " + phone + ". Получили: " + description),
                () -> assertTrue(cost.contains(sum),
                        "Сумма должна быть " + sum + ". Получили: " + cost)
        );

        payPage.backToMainPage();
    }
}