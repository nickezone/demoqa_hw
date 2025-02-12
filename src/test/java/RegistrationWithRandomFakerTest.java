import Pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static utils.RandomUtils.*;

public class RegistrationWithRandomFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    String[] genders = {"Male", "Female", "Other"},
    subjects = {"Maths", "Chemistry", "Physics", "Arts", "Social Studies"},
    hobbies = {"Sport", "Reading", "Music"},
    states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
    months = {"May", "July", "March"};

    @Test
    void successFillTest() {

        Faker faker = new Faker(new Locale("it"));

        String userName = faker.name().firstName(),
                userLastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = getRandomItemFromArray(genders),
                userAddress = faker.address().fullAddress(),
                userPhone = faker.phoneNumber().subscriberNumber(10),
                userSubject = getRandomItemFromArray(subjects),
                userHobby = getRandomItemFromArray(hobbies),
                userState = getRandomItemFromArray(states),
                randomDay = Integer.toString(faker.number().numberBetween(1, 29)),
                randomMonth = Integer.toString(faker.number().numberBetween(0, 11)),
                randomYear = String.valueOf(faker.number().numberBetween(1900, 2024));

        int userCity = getRandomInt(0, 2);

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setGender(userGender)
                .setEmail(userEmail)
                .setPhoneNumber(userPhone)
                .setBirthDate(randomDay, randomMonth, randomYear)
                .setSubject(userSubject)
                .setHobby(userHobby)
                .selectPicture("img/1.png")
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .clickSubmitButton();


        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", userName + " " + userLastName)
                .verifyResult("Gender", userGender);
    }
}
