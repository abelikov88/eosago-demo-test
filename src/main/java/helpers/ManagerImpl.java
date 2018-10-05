package helpers;

import logic.Manager;
import logic.NavigationHelper;
import logic.UserHelper;
import org.openqa.selenium.WebDriver;
import utils.PropertyLoader;
import webdriver.WebDriverFactory;

/**
 * @author abelikov
 */
public class ManagerImpl implements Manager {

    private WebDriver driver;
    private NavigationHelper navigationHelper;
    private UserHelper userHelper;
    private String baseUrl;

    public ManagerImpl() {
        String chromeDriverPath = PropertyLoader.loadProperty("chromeDriverPath");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        baseUrl = PropertyLoader.loadProperty("baseUrl");
        driver = WebDriverFactory.initWebDriver();
        userHelper = new UserHelperImpl(this);
        navigationHelper = new NavigationHelperImpl(this);
    }

    @Override
    public UserHelper getUserHelper() {
        return userHelper;
    }

    @Override
    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    protected WebDriver getWebDriver() {
        return driver;
    }

    protected String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Override
    public void close() {
        driver.close();
    }
}
