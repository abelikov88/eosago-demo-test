package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author abelikov
 */
public class PageManager {

    private WebDriver driver;
    public LoginPage loginPage;
    public OsagoAgreementPage osagoAgreementPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
        loginPage = (LoginPage) initElements(new LoginPage(this));
        osagoAgreementPage = (OsagoAgreementPage) initElements(new OsagoAgreementPage(this));
    }

    protected Page initElements(Page page) {
        PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10), page);
        return page;
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
