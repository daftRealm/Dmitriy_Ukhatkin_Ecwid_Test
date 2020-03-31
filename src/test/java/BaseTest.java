import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private static ChromeDriverService service;

    @BeforeEach
    public void createDriver() throws IOException {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/Users/dmitryukhatkin/Downloads/chromedriver"))
                .usingAnyFreePort()
                .build();
        service.start();
        Selenide.clearBrowserCookies();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = false;
        open("https://my.ecwid.com/cp/");
    }

    @AfterEach
    public void quitDriver() {
        close();
        SelenideLogger.removeListener("AllureSelenide");
        service.stop();
    }
}
