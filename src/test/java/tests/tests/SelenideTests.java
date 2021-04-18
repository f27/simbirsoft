package tests.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.TestBase;
import tests.TestData;
import tests.pages.AgreementPage;
import tests.pages.HelpPage;
import tests.pages.MainPage;
import tests.pages.PortfolioPage;

import java.util.HashMap;
import java.util.Map;

@Owner("f27")
@Tag("selenide")
@DisplayName("Tests with selenide")
public class SelenideTests extends TestBase {

    @ParameterizedTest(name = "Проверка главной страницы. Язык {0}")
    @ValueSource(strings = {"ru", "en"})
    void mainPageTest(String locale) {
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

    @ParameterizedTest(name = "Проверка страницы соглашения. Язык {0}")
    @ValueSource(strings = {"ru", "en"})
    void agreementPageTest(String locale) {

        new AgreementPage().openPage(locale)
                .hasText(TestData.getAgreement().get(locale));
    }

    @ParameterizedTest(name = "Проверка страницы портфолио. Язык {0}")
    @ValueSource(strings = {"ru", "en"})
    void portfolioPageTest(String locale) {

        new PortfolioPage().openPage(locale)
                .chooseJava()
                .hasText(TestData.getPortfolioTechnologiesJava().get(locale));
    }

    @ParameterizedTest(name = "Проверка страницы спасти продукт. Язык {0}")
    @ValueSource(strings = {"ru", "en"})
    void helpSaveProductPageTest(String locale) {

        new HelpPage().openPage(locale)
                .hasText(TestData.getHelpSave().get(locale));
    }
}
