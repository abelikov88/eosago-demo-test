package pages;

import helpers.ManagerImpl;
import logic.Manager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected Manager manager;

    @BeforeMethod
    public void init() {
        manager = new ManagerImpl();
    }

    @AfterMethod
    public void logout() {
        manager.close();
    }

    @AfterClass
    public void quit() {
        manager.quit();
    }
}
