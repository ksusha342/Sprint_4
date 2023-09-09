package praktikum.pages;

import org.openqa.selenium.By;


public class Locators {
    // Кнопка "Заказать" в верхней части главной страницы
    public static final By TOP_ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g']");
    // Кнопка "Заказать" в нижней части главной страницы
    public static final By BOTTOM_ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Заголовок "Для кого самокат" в верхней части страницы оформления заказа
    public static final By TITLE_ORDER_PAGE = By.xpath(".//div[@class='Order_Header__BZXOb']");
    // Кнопка "да все привыкли"
    public static final By ACCEPT_COOKIES_BUTTON = By.xpath(".//button[@id='rcc-confirm-button']");
    // Поле «Имя»
    public static final By CUSTOMER_NAME_FIELD = By.xpath(".//input[@placeholder='* Имя']");
    // Поле «Фамилия»
    public static final By CUSTOMER_SURNAME_FIELD = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле «Адрес»
    public static final By CUSTOMER_ADDRESS_FIELD = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле «Станция метро»
    public static final By CUSTOMER_METRO_FIELD = By.xpath(".//input[@class='select-search__input']");
    // Элемент со значением "Сокольники" в списке «Станция метро»
    public static final By CUSTOMER_METRO = By.xpath(".//button[@value='1']");
    // Поле «Телефон»
    public static final By CUSTOMER_PHONE_NUMBER_FIELD = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка «Далее»
    public static final By NEXT_BUTTON = By.xpath(".//button[text()='Далее']");
    // Поле «Когда привезти самокат»
    public static final By DELIVERY_DATE_FIELD = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Последняя дата в окне календаря
    public static final By LAST_CALENDAR_DATE = By.xpath(".//div[@class='react-datepicker__month']/div[last()]/div[last()]");
    // Поле «Срок аренды»
    public static final By RENTAL_PERIOD_FIELD = By.xpath(".//div[@class='Dropdown-control']");
    // Элемент "трое суток" в выпадающем списке срока аренды
    public static final By RENTAL_PERIOD_VALUE = By.xpath(".//div[@class='Dropdown-option' and text()='трое суток']");
    // Чекбокс цвета самоката "Чёрный жемчуг"
    public static final By BLACK_COLOR_CHECKBOX = By.xpath(".//input[@id='black']");
    // Кнопка "Заказать"
    public static final By CREATE_ORDER_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    public static final By CONFIRM_ORDER_BUTTON = By.xpath(".//button[text()='Да']");
    // Текст "Заказ оформлен"
    public static final By SUCCESS_ORDER_TITLE = By.xpath(".//div[starts-with(text(), 'Заказ оформлен')]");
}
