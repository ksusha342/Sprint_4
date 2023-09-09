package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.MainPage;
import praktikum.pages.OrderButtonPosition;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class OpenOrderPageTest {
    private final OrderButtonPosition position;
    private final boolean result;

    public OpenOrderPageTest(OrderButtonPosition position, boolean result) {
        this.position = position;
        this.result = result;
    }

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Parameterized.Parameters
    public static Object[][] getAccordionContent() {
        return new Object[][]{
                {OrderButtonPosition.top, true},
                {OrderButtonPosition.bottom, true}
        };
    }

    @Test
    public void checkOpenOrderPage() {
        MainPage mainPage = new MainPage(driverRule.getDriver());

        boolean isOpenOrderPage = mainPage.open()
                .clickOrderButton(position)
                .hasTitle();

        assertEquals(result, isOpenOrderPage);
    }
}
