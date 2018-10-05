package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author abelikov
 */
public class LoginPage extends Page {

    public LoginPage(PageManager pages) {
        super(pages);
    }

    @FindBy(id = "login")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='ui positive right button']")
    private WebElement submitButton;

    public LoginPage setLogin(String login) {
        loginField.clear();
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
