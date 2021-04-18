package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelper.*;

public class TestBase {

    @BeforeAll
    static void setup() {
        configureDriver();
    }

    @AfterEach
    void addAttachments(TestInfo info) {
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (isVideoOn()) attachVideo(sessionId);

        closeWebDriver();
    }
}
