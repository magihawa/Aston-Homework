package tests;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
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

@Epic("MTS.by")
@Feature("Блок Онлайн пополнение без комиссии")
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
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment(
                        "Screenshot",
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        "png"
                );
            } catch (Exception ignored) {
            }
            driver.quit();
        }
    }

    @Test
    @Story("Название блока")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем, что заголовок блока содержит текст Онлайн пополнение без комиссии")
    @DisplayName("1. Название блока соответствует ожидаемому")
    public void testBlockTitle() {
        String title = paymentPage.getBlockTitle();
        String normalized = title.replaceAll("\\s+", " ").trim().toLowerCase();

        assertAll("Заголовок блока",
                () -> assertFalse(title.isEmpty(),
                        "Заголовок блока пустой"),
                () -> assertTrue(normalized.contains("онлайн пополнение без комиссии"),
                        "Ожидали текст Онлайн пополнение без комиссии, а получили: " + title)
        );
    }

    @Test
    @Story("Логотипы платежных систем")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем наличие 5 логотипов платежных систем и их видимость")
    @DisplayName("2. На странице 5 логотипов платежных систем и все они видны")
    public void testLogos() {
        List<WebElement> logoElements = paymentPage.getLogos();

        assertEquals(5, logoElements.size(),
                "Ожидали 5 логотипов, а нашли: " + logoElements.size());

        assertAll("Логотипы платежных систем",
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
    @Story("Ссылка Подробнее о сервисе")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем, что ссылка открывает нужный URL и заголовок страницы совпадает")
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
    @Story("Надписи в незаполненных полях")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем placeholder-ы для всех четырех типов оплаты: услуги связи, домашний интернет, рассрочка, задолженность")
    @DisplayName("4. Надписи в незаполненных полях для каждого варианта оплаты")
    public void testPlaceholdersForAllServices() {

        paymentPage.selectService(OnlinePaymentPage.CONNECTION);
        String connectionAccount = paymentPage.getAccountPlaceholder();
        String connectionSum = paymentPage.getSumPlaceholder();
        String connectionEmail = paymentPage.getEmailPlaceholder();

        assertAll("Услуги связи",
                () -> assertTrue(connectionAccount.contains("Номер телефона"),
                        "Placeholder идентификатора: " + connectionAccount),
                () -> assertTrue(connectionSum.contains("Сумма"),
                        "Placeholder суммы: " + connectionSum),
                () -> assertTrue(connectionEmail.contains("E-mail для отправки чека"),
                        "Placeholder e-mail: " + connectionEmail)
        );

        paymentPage.selectService(OnlinePaymentPage.INTERNET);
        String internetAccount = paymentPage.getAccountPlaceholder();
        String internetSum = paymentPage.getSumPlaceholder();
        String internetEmail = paymentPage.getEmailPlaceholder();

        assertAll("Домашний интернет",
                () -> assertTrue(internetAccount.contains("Номер абонента"),
                        "Placeholder идентификатора: " + internetAccount),
                () -> assertTrue(internetSum.contains("Сумма"),
                        "Placeholder суммы: " + internetSum),
                () -> assertTrue(internetEmail.contains("E-mail для отправки чека"),
                        "Placeholder e-mail: " + internetEmail)
        );

        paymentPage.selectService(OnlinePaymentPage.INSTALLMENT);
        String installmentAccount = paymentPage.getAccountPlaceholder();
        String installmentSum = paymentPage.getSumPlaceholder();
        String installmentEmail = paymentPage.getEmailPlaceholder();

        assertAll("Рассрочка",
                () -> assertTrue(installmentAccount.contains("Номер счета на 44"),
                        "Placeholder идентификатора: " + installmentAccount),
                () -> assertTrue(installmentSum.contains("Сумма"),
                        "Placeholder суммы: " + installmentSum),
                () -> assertTrue(installmentEmail.contains("E-mail для отправки чека"),
                        "Placeholder e-mail: " + installmentEmail)
        );

        paymentPage.selectService(OnlinePaymentPage.DEBT);
        String debtAccount = paymentPage.getAccountPlaceholder();
        String debtSum = paymentPage.getSumPlaceholder();
        String debtEmail = paymentPage.getEmailPlaceholder();

        assertAll("Задолженность",
                () -> assertTrue(debtAccount.contains("Номер счета на 2073"),
                        "Placeholder идентификатора: " + debtAccount),
                () -> assertTrue(debtSum.contains("Сумма"),
                        "Placeholder суммы: " + debtSum),
                () -> assertTrue(debtEmail.contains("E-mail для отправки чека"),
                        "Placeholder e-mail: " + debtEmail)
        );
    }

    @Test
    @Story("Открытие iframe оплаты")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Заполняем форму Услуги связи, жмём Продолжить и проверяем данные в iframe оплаты")
    @DisplayName("5. Кнопка Продолжить открывает iframe с верными данными")
    public void testContinueButton() {

        assertEquals("Услуги связи", paymentPage.getSelectedServiceText(),
                "По умолчанию должен быть выбран вариант Услуги связи");

        String phone = "297777777";
        String sum = "10";
        paymentPage.enterAccount(phone);
        paymentPage.enterSum(sum);

        paymentPage.clickContinue();

        PaymentPage payPage = new PaymentPage(driver);
        assertTrue(payPage.isOpened(), "iframe оплаты не открылся");

        String description = payPage.getDescription();
        String cost = payPage.getCost();
        String buttonText = payPage.getPayButtonText();

        String cardNumberLabel = payPage.getCardNumberLabel();
        String cardExpiryLabel = payPage.getCardExpiryLabel();
        String cardCvcLabel = payPage.getCardCvcLabel();
        String cardHolderLabel = payPage.getCardHolderLabel();

        assertAll("Данные в iframe оплаты",
                () -> assertTrue(description.contains(phone),
                        "В описании нет номера " + phone + ". Получили: " + description),
                () -> assertTrue(cost.contains(sum),
                        "Стоимость должна содержать " + sum + ". Получили: " + cost),
                () -> assertTrue(buttonText.contains(sum),
                        "На кнопке должна быть сумма " + sum + ". Получили: " + buttonText),
                () -> assertEquals("Номер карты", cardNumberLabel,
                        "Подпись номера карты: " + cardNumberLabel),
                () -> assertEquals("Срок действия", cardExpiryLabel,
                        "Подпись срока действия: " + cardExpiryLabel),
                () -> assertEquals("CVC", cardCvcLabel,
                        "Подпись CVC: " + cardCvcLabel),
                () -> assertEquals("Имя и фамилия на карте", cardHolderLabel,
                        "Подпись имени держателя: " + cardHolderLabel)
        );

        assertAll("Иконки платежных систем в iframe",
                () -> assertTrue(payPage.isVisaIconVisible(),
                        "Иконка Visa не отображается"),
                () -> assertTrue(payPage.isMastercardIconVisible(),
                        "Иконка MasterCard не отображается"),
                () -> assertTrue(payPage.isBelkartIconVisible(),
                        "Иконка Белкарт не отображается")
        );

        payPage.backToMainPage();
    }
}