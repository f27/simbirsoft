package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static endpoints.Endpoints.MAIN;
import static io.qameta.allure.Allure.step;

public class MainPage {
    private static final SelenideElement
            mainHeader = $(".header__title"),
            mainPhone = $("[itemprop=telephone]"),
            mainFbLink = $("[title=Facebook]"),
            mainModalAgreementLinkText = $(".modal .link");

    private static final Map<String, String> collectedData = new HashMap<>();

    @Step("Открываем главную страницу ({locale})")
    public MainPage openPage(String locale) {
        return open(MAIN.getPath(locale), MainPage.class);
    }

    @Step("Собираем заголовок")
    public MainPage collectHeader() {
        collectedData.put("header", mainHeader.getText());

        return this;
    }

    @Step("Собираем телефон")
    public MainPage collectPhone() {
        collectedData.put("phone", mainPhone.getText());

        return this;
    }

    @Step("Собираем ссылку на FB")
    public MainPage collectFbLink() {
        collectedData.put("footerFb", mainFbLink.getAttribute("href"));

        return this;
    }

    @Step("Собираем текст кнопки связаться с нами, кликаем на нее и получаем текст ссылки")
    public MainPage collectAgreementLinkText(String buttonText) {
        step("Кликаем на кнопку " + buttonText, () ->
                $(byLinkText(buttonText)).click(usingJavaScript())
        );
        step("Собираем текст ссылки на политику защиты персональных данных", () ->
                collectedData.put("agreementLinkText", mainModalAgreementLinkText.getText())
        );

        return this;
    }

    @Step("Проверка собранных данных")
    public void checkData(Map<String, String> expectedData) {
        SoftAssertions softly = new SoftAssertions();
        collectedData.forEach((k, v) ->
                softly.assertThat(v).isEqualTo(expectedData.get(k))
        );
        softly.assertAll();
    }
}
