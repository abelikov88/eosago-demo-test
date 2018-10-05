package helpers;

import logic.NavigationHelper;

/**
 * @author abelikov
 */
public class NavigationHelperImpl extends DriverHelper implements NavigationHelper {

    private String baseUrl;

    public NavigationHelperImpl(ManagerImpl manager) {
        super(manager.getWebDriver());
        this.baseUrl = manager.getBaseUrl();
    }

    @Override
    public void openBaseUrl() {
        driver.get(baseUrl);
    }
}
