package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    public void verifyModalAppears() {

        $(".modal-dialog").shouldBe(appear);//check
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));//check
    }

    public void verifyModalResults(String key, String value){

        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

    }



}
