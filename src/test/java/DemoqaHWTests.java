import Pages.Components.RegistrationResultModal;
import Pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaHWTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successFillTest() {

        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName()
                .setGender("Male");


        $("#userEmail").setValue("alex@egorov.com");
        $("#gender-radio-1").parent().click();
        $("#genterWrapper").$(byText("Other")).click();
        $("label[for=gender-radio-1]").click();
        $("#userNumber").setValue("0123456789");

        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Miami");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        registrationPage.verifyResultModalAppears()
                .verifyResult("Student name", "Alex" + "Egorov")
                .verifyResult("Gender", "Male");
    }
}
