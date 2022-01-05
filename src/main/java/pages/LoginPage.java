package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница авторизации
 */
public class LoginPage extends HelpdeskBasePage {

    // todo: элементы страницы

    @FindBy(xpath = "//input[contains(@id, 'username')]")
    private WebElement fillUsername;

    @FindBy(xpath = "//input[contains(@id, 'password')]")
    private WebElement fillPassword;

    @FindBy(xpath = "//input[@value='remember-me']")
    private WebElement rememberPasswordCheckbox;

    @FindBy(xpath = "//input[@value= 'Login']")
    private WebElement loginBtn;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Авторизация пользователя
     *
     * @param user     логин пользователя
     * @param password пароль пользователя
     */
    public void login(String user, String password) {
        // todo: заполнить поля и нажать кнопку авторизации
        fillUsername.sendKeys(user);
        fillPassword.sendKeys(password);
        rememberPasswordCheckbox.click();
        loginBtn.click();
    }

    // todo: методы работы с элементами
}
