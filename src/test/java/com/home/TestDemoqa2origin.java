package com.home;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.TestBase;

public class TestDemoqa2origin extends TestBase {

    @Test
    void autoTest2() {

        RegistrationPage registrationPage = new RegistrationPage();
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = faker.demographic().sex();
        String mobile = faker.phoneNumber().subscriberNumber(12);
        String currentAddress = faker.address().streetAddress();
        String filePath = "src/test/resources/img/02.png";


        registrationPage.openPage();
        registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGenter(gender)
                .setMobile(mobile)
                .setBirthDay("28","April","1990")
                .verifySubjects("Maths", "English")
                .verifyHobbies("Sports", "Reading", "Music")
                .verifyUpload(filePath)
                .verifyAddress(currentAddress)
                .verifyState("Haryana")
                .verifyCity("Karnal")
                .submit();



        registrationPage.verifyModalAppears()
                        .verifyModalResults("Student Name", firstName + lastName)
                        .verifyModalResults("Student Email", email)
                        .verifyModalResults("Gender", gender)
                        .verifyModalResults("Mobile", mobile)
                        .verifyModalResults("Subjects", "Maths, English")
                        .verifyModalResults("Hobbies", "Sports")
                        .verifyModalResults("Picture", "02.png")
                        .verifyModalResults("Address", currentAddress)
                        .verifyModalResults("State and City", "Haryana Karnal");


    }

}
