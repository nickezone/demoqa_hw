import Pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static utils.RandomUtils.*;

public class RegistrationWithRandomFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    String[] genders = {"Male", "Female", "Other"};

    @Test
    void successFillTest() {

        Faker faker = new Faker(new Locale("it"));

        String userName = faker.name().firstName(),
                userLastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = getRandomItemFromArray(genders),
                userAddress = faker.address().fullAddress(),
                userPhone = faker.phoneNumber().subscriberNumber(10);
        //   randomDay = faker.number.numberBetween(); // todo задать вопрос как поступить в такой ситуации


        int userCity = getRandomInt(0, 2);

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setGender(userGender)
                .setEmail(userEmail)
                .setPhoneNumber(userPhone)
                .setBirthDate("29", "May", "2001")
                .setSubject("Maths")
                .setHobby("Sports")
                .selectPicture("img/1.png")
                .setAddress(userAddress)
                .setState("NCR")
                .setCity(userCity)
                .clickSubmitButton();


        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", "Alex " + "Egorov")
                .verifyResult("Gender", "Male");
    }
}
