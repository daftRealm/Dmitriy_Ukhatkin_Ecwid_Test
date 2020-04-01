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
    @Description("Проверка ввода значений в полях Эл. почта/Пароль на странице")
    void setValuesInFieldsTest() {

        String validEmail = "ukhatkind@gmail.com";
        String validPassword = "Dima123456";

        mainPage.setValueInFieldEmail(validEmail)
                .setValueInFieldPassword(validPassword);
        if (mainPage.checkSignInButtonVisible()) {
            mainPage.clickOnSignInButton();
        }

    }

    @Test
    @Description("Отображение предупреждения при вводе невалидного значения эл. почты")
    void checkEmailFieldInvalidValuesTest() {

        String invalidEmail = "ukhatkin@gmail.com";
        String validPassword = "Dima123456";

        mainPage.setValueInFieldEmail(invalidEmail)
                .setValueInFieldPassword(validPassword)
                .clickOnSignInButton()
                .checkInvalidEmail();
    }

    @Test
    @Description("Отображение предупреждения при вводе невалидного значения пароля")
    void checkPasswordFieldInvalidValuesTest() {

        String validEmail = "ukhatkind@gmail.com";
        String invalidPassword = "123456";

        mainPage.setValueInFieldEmail(validEmail)
                .setValueInFieldPassword(invalidPassword)
                .clickOnSignInButton()
                .checkInvalidPassword();
    }

    @Test
    @Description("Предупреждения при вводе валидных значения эл. почты и пароля не отображаются")
    void checkEmailPasswordFieldValidValuesTest() {

        String validEmail = "ukhatkind@gmail.com";
        String invalidPassword = "Dima123456";

        mainPage.setValueInFieldEmail(validEmail)
                .setValueInFieldPassword(invalidPassword)
                .clickOnSignInButton()
                .checkValidEmail()
                .checkValidPassword();
    }

    @Test
    @Description("После ввода валидных данных и нажатия на кнопку Войти, отображается экран Магазина")
    void checkStorePageIsDisplayedTest() {

        String validEmail = "ukhatkind@gmail.com";
        String validPassword = "Dima123456";

        mainPage.checkEmailField()
                .checkPasswordField()
                .setValueInFieldEmail(validEmail)
                .setValueInFieldPassword(validPassword);
        if (mainPage.checkSignInButtonVisible()) {
            mainPage.clickOnSignInButton()
                    .checkStorePageIsDisplayed();
        }
    }
}