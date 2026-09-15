package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By iframe = By.cssSelector("iframe.payment-widget-iframe");
    private By description = By.cssSelector(".pay-description__text");
    private By cost = By.cssSelector(".pay-description__cost");
    private By payButton = By.cssSelector("button[type='submit'].colored");

    private By cardNumberLabel = By.cssSelector("input[autocomplete='cc-number'] + label");
    private By cardExpiryLabel = By.cssSelector("input[autocomplete='cc-exp'] + label");
    private By cardCvcLabel = By.cssSelector("input[autocomplete='cc-csc'] + label");
    private By cardHolderLabel = By.cssSelector("input[autocomplete='cc-name'] + label");

    private By visaIcon = By.cssSelector("img[src*='visa-system']");
    private By mastercardIcon = By.cssSelector("img[src*='mastercard-system']");
    private By belkartIcon = By.cssSelector("img[src*='belkart-system']");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Step("Переключиться в iframe оплаты")
    public boolean isOpened() {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Вернуться из iframe в основной документ")
    public void backToMainPage() {
        driver.switchTo().defaultContent();
    }

    @Step("Получить описание заказа")
    public String getDescription() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(description));
        return element.getText();
    }

    @Step("Получить стоимость заказа")
    public String getCost() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(cost));
        return element.getText();
    }

    @Step("Получить текст кнопки оплаты")
    public String getPayButtonText() {
        WebElement button = wait.until(
                ExpectedConditions.visibilityOfElementLocated(payButton));
        return button.getText();
    }

    @Step("Получить подпись поля номера карты")
    public String getCardNumberLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberLabel))
                .getText();
    }

    @Step("Получить подпись поля срока действия")
    public String getCardExpiryLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardExpiryLabel))
                .getText();
    }

    @Step("Получить подпись поля CVC")
    public String getCardCvcLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardCvcLabel))
                .getText();
    }

    @Step("Получить подпись поля имени держателя карты")
    public String getCardHolderLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardHolderLabel))
                .getText();
    }

    @Step("Проверить, что иконка Visa видна")
    public boolean isVisaIconVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(visaIcon))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Проверить, что иконка MasterCard видна")
    public boolean isMastercardIconVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(mastercardIcon))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Проверить, что иконка Белкарт видна")
    public boolean isBelkartIconVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(belkartIcon))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}