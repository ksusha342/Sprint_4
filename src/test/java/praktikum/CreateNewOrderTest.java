package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.OrderPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CreateNewOrderTest {
    private final boolean isCreated;
    private final String customerName;
    private final String customerSurname;
    private final String customerAddress;
    private final String customerPhoneNumber;
    public CreateNewOrderTest(String customerName, String customerSurname, String customerAddress, String customerPhoneNumber, boolean isCreated) {
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        this.isCreated = isCreated;
    }

    @Rule
    public DriverRule driverRule = new DriverRule();
    @Parameterized.Parameters
    public static Object[][] createOrder() {
        return new Object[][] {
                { "Ян", "Ли", "Ивантеевская улица, 23",  "+7999999999", true},
                { "Мариня", "Петрова", "Красная площадь", "89111111111", true},
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
                .confirmCreateOrder();

        assertEquals(isCreated, orderPage.hasCreateOrderText());
    }
}