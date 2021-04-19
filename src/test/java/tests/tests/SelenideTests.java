package tests.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tests.TestBase;
import tests.TestData;
import tests.pages.AgreementPage;
import tests.pages.HelpPage;
import tests.pages.MainPage;
import tests.pages.PortfolioPage;

import java.util.HashMap;
import java.util.Map;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

@Owner("f27")
@Tag("selenide")
@DisplayName("Тесты с selenide")
public class SelenideTests extends TestBase {

    @Test
    @Feature("Главная страница")
    void mainPageTest() {
        for (String locale : TestData.getLocales()) {
            Map<String, String> expectedData = new HashMap<String, String>() {{
                put("header", TestData.getMainHeader().get(locale));
                put("phone", TestData.getMainPhone().get(locale));
                put("footerFb", TestData.getMainFooterFb().get(locale));
                put("agreementLinkText", TestData.getElementsLinkAgreement().get(locale));
            }};
            step("Проверка главной страницы. Язык " + locale, (step) -> {
                step.parameter("locale", locale);
                new MainPage().openPage(locale)
                        .collectHeader()
                        .collectPhone()
                        .collectFbLink()
                        .collectAgreementLinkText(TestData.getElementsButtonContact().get(locale))
                        .checkData(expectedData);
            });
        }
    }

    @Test
    @Feature("Главная страница")
    void agreementPageTest() {
        for (String locale : TestData.getLocales()) {

            new AgreementPage().openPage(locale)
                    .hasText(TestData.getAgreement().get(locale));
        }
    }

    @Test
    @Feature("Портфолио")
    void portfolioPageTest() {
        for (String locale : TestData.getLocales()) {

            new PortfolioPage().openPage(locale)
                    .chooseJava()
                    .hasText(TestData.getPortfolioTechnologiesJava().get(locale));
        }
    }

    @Test
    @Feature("Услуги")
    void helpSaveProductPageTest() {
        for (String locale : TestData.getLocales()) {

            new HelpPage().openPage(locale)
                    .hasText(TestData.getHelpSave().get(locale));
        }
    }
}
