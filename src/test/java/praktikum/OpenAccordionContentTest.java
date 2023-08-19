package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OpenAccordionContentTest {
    private final int index;
    private final String accordionContent;
    private final boolean result;

    public OpenAccordionContentTest(int index, String accordionContent, boolean result) {
        this.index = index;
        this.accordionContent = accordionContent;
        this.result = result;
    }

    @Rule
    public DriverRule driverRule = new DriverRule();
    @Parameterized.Parameters
    public static Object[][] getAccordionContent() {
        return new Object[][] {
                { 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", true},
                { 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", true},
                { 2, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", false},
        };
    }

    @Test
    public void checkAccordionContent() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .clickOnAccordionElementBy(index)
                .waitOpenAccordionContent(index);
        String currentContent = mainPage.getAccordionContentBy(index);
        Boolean actual = accordionContent.contentEquals(currentContent);
        assertEquals(result, actual);
    }
}