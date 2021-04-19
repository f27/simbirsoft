package tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static endpoints.Endpoints.PORTFOLIO;

public class PortfolioPage {
    private static final SelenideElement
            javaButton = $("[data-code=java]");

    private static final ElementsCollection
            titles = $$(".portfolio__title");

    @Step("Открываем страницу портфолио по технологиям ({locale})")
    public PortfolioPage openPage(String locale) {
        return open(PORTFOLIO.addPath("/technologies", locale), PortfolioPage.class);
    }

    @Step("Выбираем технологию Java")
    public PortfolioPage chooseJava() {
        javaButton.click();

        return this;
    }

    @Step("Проверяем, что есть {searchText}")
    public void hasText(String searchText) {
        titles.findBy(text(searchText)).shouldBe(visible);
    }
}
