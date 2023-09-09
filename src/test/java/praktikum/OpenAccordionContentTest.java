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
                { 2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", true},
                { 3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", true},
                { 4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", true},
                { 5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", true},
                { 6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", true},
                { 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", true},
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