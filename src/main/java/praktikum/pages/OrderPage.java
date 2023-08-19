package praktikum.pages;

import org.openqa.selenium.WebDriver;

import static praktikum.pages.Locators.*;

public class OrderPage {

    final String ORDER_PAGE_URL = "https://qa-scooter.praktikum-services.ru/order";
    final int DEFAULT_WAIT_INTERVAL = 3;
    final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage open() {
        driver.get(ORDER_PAGE_URL);
        return this;
    }

    public OrderPage acceptCookies() {
        driver.findElement(ACCEPT_COOKIES_BUTTON).click();
        return this;
    }

    public OrderPage typeCustomerName(String name) {
        driver.findElement(CUSTOMER_NAME_FIELD).click();
        driver.findElement(CUSTOMER_NAME_FIELD).sendKeys(name);
        return this;
    }

    public OrderPage typeCustomerSurname(String surname) {
        driver.findElement(CUSTOMER_SURNAME_FIELD).click();
        driver.findElement(CUSTOMER_SURNAME_FIELD).sendKeys(surname);
        return this;
    }

    public OrderPage typeCustomerAddress(String address) {
        driver.findElement(CUSTOMER_ADDRESS_FIELD).click();
        driver.findElement(CUSTOMER_ADDRESS_FIELD).sendKeys(address);
        return this;
    }

    public OrderPage typeCustomerMetro() {
        driver.findElement(CUSTOMER_METRO_FIELD).click();
        driver.findElement(CUSTOMER_METRO).click();
        return this;
    }

    public OrderPage typeCustomerPhoneNumber(String phoneNumber) {
        driver.findElement(CUSTOMER_PHONE_NUMBER_FIELD).click();
        driver.findElement(CUSTOMER_PHONE_NUMBER_FIELD).sendKeys(phoneNumber);
        return this;
    }

    public OrderPage clickNextButton() {
        driver.findElement(NEXT_BUTTON).click();
        return this;
    }

    public OrderPage typeDeliveryDate() {
        driver.findElement(DELIVERY_DATE_FIELD).click();
        driver.findElement(LAST_CALENDAR_DATE).click();
        return this;
    }

    public OrderPage typeRentalPeriod() {
        driver.findElement(RENTAL_PERIOD_FIELD).click();
        driver.findElement(RENTAL_PERIOD_VALUE).click();
        return this;
    }

    public OrderPage clickBlackColorScooter() {
        driver.findElement(BLACK_COLOR_CHECKBOX).click();
        return this;
    }

    public OrderPage clickCreateOrder() {
        driver.findElement(CREATE_ORDER_BUTTON).click();
        return this;
    }

    public OrderPage confirmCreateOrder() {
        driver.findElement(CONFIRM_ORDER_BUTTON).click();
        return this;
    }

    public boolean hasCreateOrderText() {
        return driver.findElement(SUCCESS_ORDER_TITLE).isDisplayed();
    }

    public boolean hasTitle() {
        return driver.findElement(TITLE_ORDER_PAGE).isDisplayed();
    }

}
