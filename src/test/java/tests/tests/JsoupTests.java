package tests.tests;

import io.qameta.allure.Owner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.TestBase;
import tests.TestData;

import java.io.IOException;

import static endpoints.Endpoints.MAIN;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("f27")
@Tag("jsoup")
public class JsoupTests {

    @ParameterizedTest(name = "Проверка ссылки на FB с помощью jsoup. Язык {0}")
    @ValueSource(strings = {"ru", "en"})
    void exampleTest(String locale) throws IOException {
        Document page = Jsoup.connect(TestData.getWebUrl()+MAIN.getPath(locale)).get();
        assertThat(page.select("[title=Facebook]").attr("href"))
                .isEqualTo(TestData.getMainFooterFb().get(locale));
    }

}
