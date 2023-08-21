package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.OrderPage;


@RunWith(Parameterized.class)
public class CreateNewOrderTest {
    private final String customerName;
    private final String customerSurname;
    private final String customerAddress;
    private final String customerPhoneNumber;
    public CreateNewOrderTest(String customerName, String customerSurname, String customerAddress, String customerPhoneNumber) {
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    @Rule
    public DriverRule driverRule = new DriverRule();
    @Parameterized.Parameters
    public static Object[][] createOrder() {
        return new Object[][] {
                { "Ян", "Ли", "Ивантеевская улица, 23",  "+7999999999"},
                { "Мариня", "Петрова", "Красная площадь", "89111111111"},
        };
    }

    @Test
    public void createNewOrder() {
        OrderPage orderPage = new OrderPage(driverRule.getDriver());

        orderPage.open()
                .acceptCookies()
                .typeCustomerName(customerName)
                .typeCustomerSurname(customerSurname)
                .typeCustomerAddress(customerAddress)
                .typeCustomerMetro()
                .typeCustomerPhoneNumber(customerPhoneNumber)
                .clickNextButton()
                .typeDeliveryDate()
                .typeRentalPeriod()
                .clickBlackColorScooter()
                .clickCreateOrder()
                .confirmCreateOrder()
                .hasCreateOrderText();
    }
}