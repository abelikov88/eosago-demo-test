package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageManager;

/**
 * @author abelikov
 */
public class DriverHelper {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PageManager pages;

    public DriverHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        pages = new PageManager(driver);
    }
}
