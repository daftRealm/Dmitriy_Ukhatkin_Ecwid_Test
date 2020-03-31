import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;


public class MainPageTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @Test
    @Description("Тест проверки отображения элементов на странице")
    void visibilityElementsTest() {

        mainPage.checkEmailField()
                .checkPasswordField()
                .checkSignInButtonVisible();
    }

    @Test
    @Description("Тест проверки ввода информации в полях для логина на странице")
    void setValuesInFieldsTest() {

        String validEmail = "ukhatkind@gmail.com";
        String validPassword = "Dima123456";

        mainPage.checkEmailField()
                .checkPasswordField()
                .setValueInFieldEmail(validEmail)
                .setValueInFieldPassword(validPassword)
                .checkSignInButtonVisible()
                .clickOnSignInButton();
    }

    @Test
    @Description("Тест проверки отображения предупреждения при вводе невалидного значения эл. почты")
    void checkEmailFieldInvalidValues() {

        String invalidEmail = "ukhatkin@gmail.com";
        String validPassword = "Dima123456";

        mainPage.setValueInFieldEmail(invalidEmail)
                .setValueInFieldPassword(validPassword)
                .clickOnSignInButton()
                .checkInvalidEmail();
    }

    @Test
    @Description("Тест проверки отображения предупреждения при вводе невалидного значения пароля")
    void checkPasswordFieldInvalidValues() {

        String validEmail = "ukhatkind@gmail.com";
        String invalidPassword = "123456";

        mainPage.setValueInFieldEmail(validEmail)
                .setValueInFieldPassword(invalidPassword)
                .clickOnSignInButton()
                .checkInvalidPassword();
    }

}
