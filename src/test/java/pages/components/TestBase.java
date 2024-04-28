package pages.components;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {


    @BeforeAll
    static void Beforeall() {
        Configuration.browserSize = "1100x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "firefox";

    }

}
