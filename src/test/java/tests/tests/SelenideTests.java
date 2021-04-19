package tests.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.TestData;
import tests.pages.AgreementPage;
import tests.pages.HelpPage;
import tests.pages.MainPage;
import tests.pages.PortfolioPage;

import java.util.HashMap;
import java.util.Map;

import static io.qameta.allure.Allure.parameter;

@Owner("f27")
@Tag("selenide")
@DisplayName("Тесты с selenide")
public class SelenideTests extends TestBase {
    private final String[] locales = TestData.getLocales();

    @Test
    @Feature("Главная страница")
    @DisplayName("Проверка главной страницы")
    void mainPageTest() {
        parameter("locales", locales);
        for (String locale : locales) {
            Map<String, String> expectedData = new HashMap<String, String>() {{
                put("header", TestData.getMainHeader().get(locale));
                put("phone", TestData.getMainPhone().get(locale));
                put("footerFb", TestData.getMainFooterFb().get(locale));
                put("agreementLinkText", TestData.getElementsLinkAgreement().get(locale));
            }};
            new MainPage().openPage(locale)
                    .collectHeader()
                    .collectPhone()
                    .collectFbLink()
                    .collectAgreementLinkText(TestData.getElementsButtonContact().get(locale))
                    .checkData(expectedData);
        }
    }

    @Test
    @Feature("Страница соглашения")
    @DisplayName("Проверка страницы соглашения")
    void agreementPageTest() {
        parameter("locales", locales);
        for (String locale : locales) {

            new AgreementPage().openPage(locale)
                    .hasText(TestData.getAgreement().get(locale));
        }
    }

    @Test
    @Feature("Портфолио")
    @DisplayName("Проверка портфолио")
    void portfolioPageTest() {
        parameter("locales", locales);
        for (String locale : locales) {

            new PortfolioPage().openPage(locale)
                    .chooseJava()
                    .hasText(TestData.getPortfolioTechnologiesJava().get(locale));
        }
    }

    @Test
    @Feature("Услуги")
    @DisplayName("Проверка услуг")
    void helpSaveProductPageTest() {
        parameter("locales", locales);
        for (String locale : locales) {

            new HelpPage().openPage(locale)
                    .hasText(TestData.getHelpSave().get(locale));
        }
    }
}
