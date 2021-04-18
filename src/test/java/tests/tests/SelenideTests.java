package tests.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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

@Owner("f27")
@Tag("selenide")
@DisplayName("Тесты с selenide")
public class SelenideTests extends TestBase {
    static String[] localesProvider() {
        return TestData.getLocales();
    }

    @Feature("Главная страница")
    @ParameterizedTest(name = "Проверка главной страницы. Язык {0}")
    @MethodSource("localesProvider")
    void mainPageTest(String locale) {
        parameter("locale", locale);
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

    @Feature("Страница соглашения")
    @ParameterizedTest(name = "Проверка страницы соглашения. Язык {0}")
    @MethodSource("localesProvider")
    void agreementPageTest(String locale) {
        parameter("locale", locale);

        new AgreementPage().openPage(locale)
                .hasText(TestData.getAgreement().get(locale));
    }

    @Feature("Портфолио")
    @ParameterizedTest(name = "Проверка страницы портфолио. Язык {0}")
    @MethodSource("localesProvider")
    void portfolioPageTest(String locale) {
        parameter("locale", locale);

        new PortfolioPage().openPage(locale)
                .chooseJava()
                .hasText(TestData.getPortfolioTechnologiesJava().get(locale));
    }

    @Feature("Услуги")
    @ParameterizedTest(name = "Проверка страницы спасти продукт. Язык {0}")
    @MethodSource("localesProvider")
    void helpSaveProductPageTest(String locale) {
        parameter("locale", locale);

        new HelpPage().openPage(locale)
                .hasText(TestData.getHelpSave().get(locale));
    }
}
