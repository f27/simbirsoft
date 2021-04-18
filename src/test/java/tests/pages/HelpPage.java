package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static endpoints.Endpoints.HELP;

public class HelpPage {
    private static final SelenideElement
            headerTitle = $(".header__title");

    @Step("Открываем страницу в разделе услуги ({locale})")
    public HelpPage openPage(String locale) {
        return open(HELP.addPath("/save-a-product", locale), HelpPage.class);
    }

    @Step("Проверяем, что в заголовке есть {searchText}")
    public void hasText(String searchText) {
        headerTitle.shouldHave(text(searchText));
    }
}
