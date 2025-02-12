
import org.junit.jupiter.api.Test;
import page.objects.RegistrationPage;

import static utils.RandomUtils.*;

public class RegistrationWithRandomUtilsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    String[] genders = {"Male", "Female", "Other"};

    @Test
    void successFillTest() {

        String userName = getRandomString(10),
                userLastName = getRandomString(10),
                userEmail = getRandomEmail(),
                userGender = getRandomItemFromArray(genders);

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setGender(userGender)
                .setEmail(userEmail)
                .setPhoneNumber("0123456789")
                .setBirthDate("29", "May", "2001")
                .setSubject("Maths")
                .setHobby("Sports")
                .selectPicture("img/1.png")
                .setAddress("Miami")
                .setState("NCR")
                .setCity(1)
                .clickSubmitButton();


        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", "Alex " + "Egorov")
                .verifyResult("Gender", "Male");
    }
}
