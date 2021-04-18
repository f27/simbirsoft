package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelper.*;

public class TestBase {

    @BeforeEach
    void setup() {
        configureDriver();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (isVideoOn()) attachVideo(sessionId);

        closeWebDriver();
    }
}
