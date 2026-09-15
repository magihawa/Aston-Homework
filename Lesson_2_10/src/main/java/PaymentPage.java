package pages;

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

    private By cardNumber = By.cssSelector("input[autocomplete='cc-number']");
    private By cardExpiry = By.cssSelector("input[autocomplete='cc-exp']");
    private By cardCvc = By.cssSelector("input[autocomplete='cc-csc']");
    private By cardHolder = By.cssSelector("input[autocomplete='cc-name']");

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

    public boolean isOpened() {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void backToMainPage() {
        driver.switchTo().defaultContent();
    }

    public String getDescription() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(description));
        return element.getText();
    }

    public String getCost() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(cost));
        return element.getText();
    }

    public String getPayButtonText() {
        WebElement button = wait.until(
                ExpectedConditions.visibilityOfElementLocated(payButton));
        return button.getText();
    }

    public String getCardNumberLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberLabel))
                .getText();
    }

    public String getCardExpiryLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardExpiryLabel))
                .getText();
    }

    public String getCardCvcLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardCvcLabel))
                .getText();
    }

    public String getCardHolderLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardHolderLabel))
                .getText();
    }

    public boolean isVisaIconVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(visaIcon))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isMastercardIconVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(mastercardIcon))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isBelkartIconVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(belkartIcon))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}