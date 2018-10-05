package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver initWebDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
