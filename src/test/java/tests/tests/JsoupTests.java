package tests.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.TestData;

import java.io.IOException;

import static endpoints.Endpoints.MAIN;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("f27")
@Tag("jsoup")
@DisplayName("Tests with jsoup")
public class JsoupTests {

    @Feature("Главная страница")
    @ParameterizedTest(name = "Проверка ссылки на FB с помощью jsoup. Язык {0}")
    @ValueSource(strings = {"ru", "en"})
    void exampleTest(String locale) throws IOException {
        String url = TestData.getWebUrl() + MAIN.getPath(locale);
        Document page = openPage(url);
        step("Сравниваем ссылку", () ->
                assertThat(page.select("[title=Facebook]").attr("href"))
                        .isEqualTo(TestData.getMainFooterFb().get(locale))
        );
    }

    @Step("Открываем страницу")
    private Document openPage(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

}
