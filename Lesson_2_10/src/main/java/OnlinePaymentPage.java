package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OnlinePaymentPage {

    public static final String CONNECTION = "Услуги связи";
    public static final String INTERNET = "Домашний интернет";
    public static final String INSTALLMENT = "Рассрочка";
    public static final String DEBT = "Задолженность";

    private WebDriver driver;
    private WebDriverWait wait;

    private By blockTitle = By.xpath(
            "//*[@id='pay-section']//h2[contains(text(),'Онлайн пополнение')]");
    private By logos = By.cssSelector(".pay__partners img");
    private By detailsLink = By.xpath(
            "//*[@id='pay-section']//a[contains(text(),'Подробнее о сервисе')]");

    private By selectHeader = By.cssSelector(".select__header");
    private By selectedServiceText = By.cssSelector("#pay-section .select__now");

    public OnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getBlockTitle() {
        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(blockTitle));
        return title.getText();
    }

    public List<WebElement> getLogos() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(logos, 0));
        return driver.findElements(logos);
    }

    public boolean isLogoVisible(String alt) {
        By logo = By.cssSelector(".pay__partners img[alt='" + alt + "']");
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickDetailsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(detailsLink)).click();
    }

    public void selectService(String serviceName) {
        wait.until(ExpectedConditions.elementToBeClickable(selectHeader)).click();

        By option = By.xpath(
                "//p[@class='select__option' and normalize-space()='" + serviceName + "']");
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".pay__forms form.opened")));
    }

    public String getSelectedServiceText() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(selectedServiceText));
        return element.getText();
    }

    private By getAccountField() {
        String service = getSelectedServiceText();
        if (service.equals(CONNECTION)) {
            return By.id("connection-phone");
        } else if (service.equals(INTERNET)) {
            return By.id("internet-phone");
        } else if (service.equals(INSTALLMENT)) {
            return By.id("score-instalment");
        } else {
            return By.id("score-arrears");
        }
    }

    private By getSumField() {
        String service = getSelectedServiceText();
        if (service.equals(CONNECTION)) {
            return By.id("connection-sum");
        } else if (service.equals(INTERNET)) {
            return By.id("internet-sum");
        } else if (service.equals(INSTALLMENT)) {
            return By.id("instalment-sum");
        } else {
            return By.id("arrears-sum");
        }
    }

    private By getEmailField() {
        String service = getSelectedServiceText();
        if (service.equals(CONNECTION)) {
            return By.id("connection-email");
        } else if (service.equals(INTERNET)) {
            return By.id("internet-email");
        } else if (service.equals(INSTALLMENT)) {
            return By.id("instalment-email");
        } else {
            return By.id("arrears-email");
        }
    }

    public String getAccountPlaceholder() {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(getAccountField()));
        return input.getAttribute("placeholder");
    }

    public String getSumPlaceholder() {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(getSumField()));
        return input.getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(getEmailField()));
        return input.getAttribute("placeholder");
    }

    public void enterAccount(String value) {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(getAccountField()));
        input.clear();
        input.sendKeys(value);
    }

    public void enterSum(String sum) {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(getSumField()));
        input.clear();
        input.sendKeys(sum);
    }

    public void clickContinue() {
        By continueButton = By.cssSelector(".pay__forms form.opened button[type='submit']");
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
}