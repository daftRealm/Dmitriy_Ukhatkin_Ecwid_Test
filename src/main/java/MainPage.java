import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import utilities.BaseStep;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class MainPage extends BaseStep {

    private SelenideElement emailField = $$("div.fieldset--with-label").get(0);
    private SelenideElement passwordField = $$("div.fieldset--with-label").get(1);
    private SelenideElement signInButton = $$("button.btn-login-main").findBy(Condition.text("Войти"));
    private SelenideElement errorNotification = $("div.bubble-error");

    @Step("Проверка, что отображаются поле Эл. почта")
    public MainPage checkEmailField() {
        emailField
                .scrollIntoView("{block: \"center\"}")
                .waitUntil(Condition.visible, 10000);
        if (emailField.exists() && emailField.isDisplayed()) {
            Assertions.assertTrue(emailField.getText().equals("Эл. почта"), "Поле страницы должно быть для ввода эл. почты");
        }
        return this;
    }

    @Step("Проверка, что отображаются поле Пароль")
    public MainPage checkPasswordField() {
        passwordField
                .scrollIntoView("{block: \"center\"}")
                .waitUntil(Condition.visible, 10000);
        if (passwordField.exists() && passwordField.isDisplayed()) {
            Assertions.assertTrue(passwordField.getText().equals("Пароль"), "Поле страницы должно быть для ввода пароля");
        }
        return this;
    }

    @Step("Ввод данных в поле Эл. почта")
    public MainPage setValueInFieldEmail(String value) {
        emailField.$("input").setValue(value);
        setTimeout(2000);
        return this;
    }

    @Step("Ввод данных в поле Пароль")
    public MainPage setValueInFieldPassword(String value) {
        passwordField.$("input").setValue(value);
        setTimeout(2000);
        return this;
    }

    @Step("Проверка, что кнопка Войти отображается")
    public MainPage checkSignInButtonVisible() {
        signInButton.scrollIntoView("{block: \"center\"}").waitUntil(Condition.visible, 10000);
        Assertions.assertTrue(signInButton.exists() && signInButton.isDisplayed(), "Кнопка Логин не отображается");
        return this;
    }

    @Step("Клик по кнопке Логин")
    public MainPage clickOnSignInButton() {
        signInButton.scrollIntoView("{block: \"center\"}").waitUntil(Condition.visible, 10000).click();
        return this;
    }

    @Step("Проверка отображения предупреждении о вводе неправильной эл. почты")
    public MainPage checkInvalidEmail() {
        emailField.shouldHave(Condition.cssClass("has-error"));
        errorNotification.waitUntil(Condition.visible, 10000);
        Assertions.assertTrue(errorNotification.exists() && errorNotification.isDisplayed(), "Не появилось сообщение о вводе неправильной эл. почты");
        return this;
    }

    @Step("Проверка отображения предупреждении о вводе неправильного пароля")
    public MainPage checkInvalidPassword() {
        passwordField.shouldHave(Condition.cssClass("has-error"));
        errorNotification.waitUntil(Condition.visible, 10000);
        Assertions.assertTrue(errorNotification.exists() && errorNotification.isDisplayed(), "Не появилось сообщение о вводе неправильного пароля");
        return this;
    }
}
