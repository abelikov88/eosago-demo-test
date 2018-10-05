package pages;

import org.openqa.selenium.WebDriver;

/**
 * @author abelikov
 */
public abstract class Page {

    protected WebDriver driver;
    protected PageManager pages;

    public Page(PageManager pages) {
        this.pages = pages;
        driver = pages.getWebDriver();
    }
}
