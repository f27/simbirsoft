package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static endpoints.Endpoints.AGREEMENT;

public class AgreementPage {
    private static final SelenideElement
            agreementText = $(".about-agreement");

    @Step("Открываем страницу соглашения ({locale})")
    public AgreementPage openPage(String locale) {
        return open(AGREEMENT.getPath(locale), AgreementPage.class);
    }

    @Step("Проверяем, что есть текст {searchText}")
    public void hasText(String searchText) {
        agreementText.shouldHave(text(searchText));
    }
}
