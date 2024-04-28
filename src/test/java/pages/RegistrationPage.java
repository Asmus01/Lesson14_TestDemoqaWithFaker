package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();




    private final String TITLE_TEXT = "Student Registration Form";
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");


    public RegistrationPage openPage() {

        open("/automation-practice-form");
        $("#app").shouldHave(text(TITLE_TEXT));//check page of site, constant TITLE_TEXT
        Selenide.executeJavaScript("$('#RightSide_Advertisement').remove()");//delete ads-banners
        Selenide.executeJavaScript("$('footer').remove()");
        Selenide.executeJavaScript("$('#fixedban').remove()");//delete footer
        return this;

    }

    public RegistrationPage setFirstName(String value) {

        firstNameInput.setValue(value);
        return this;

    }

    public RegistrationPage setLastName(String value) {

        lastNameInput.setValue(value);
        return this;

    }

    public RegistrationPage setEmail(String value) {

        $("#userEmail").setValue(value);
        return this;

    }

    public RegistrationPage setGenter(String value) {

        $("#genterWrapper").$(byText(value)).click();// best
        return this;

    }

    public RegistrationPage setMobile(String value) {

        $("#userNumber").setValue(value).click();
        return this;

    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;

    }

    public RegistrationPage verifyModalAppears() {

        registrationResultsModal.verifyModalAppears();
        return this;

    }

        public RegistrationPage verifyModalResults (String key, String value){

            registrationResultsModal.verifyModalResults(key, value);
            return this;

    }

        public RegistrationPage verifySubjects (String value1, String value2){

            $("#subjectsInput").setValue(value1).pressEnter();
            $("#subjectsInput").setValue("e");
            $(byText(value2)).click();
            return this;

    }

        public RegistrationPage verifyHobbies (String value01, String value02, String value03){

            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#hobbiesWrapper").$(byText("Reading")).click();
            $("#hobbiesWrapper").$(byText("Music")).click();
            return this;

    }

        public RegistrationPage verifyUpload (String value){

            $("input#uploadPicture").uploadFile(new File(value));
            return this;

    }

        public RegistrationPage verifyAddress (String value){

            $("#currentAddress").setValue(value);
            return this;

    }

        public RegistrationPage verifyState (String value){

            $("#state").click();
            $(byText(value)).click();
            return this;

    }

        public RegistrationPage verifyCity (String value){

            $("#city").click();
            $(byText(value)).click();
            return this;


    }

        public RegistrationPage submit () {

            $("#submit").click();
            return this;

        }
}




