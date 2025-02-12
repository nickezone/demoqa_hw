import org.junit.jupiter.api.Test;
import page.objects.RegistrationPage;

public class DemoqaHWTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successFillTest() {

        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setGender("Male")
                .setEmail("alex@egorov.com")
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