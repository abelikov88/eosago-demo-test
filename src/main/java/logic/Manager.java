package logic;

public interface Manager {

    UserHelper getUserHelper();

    NavigationHelper getNavigationHelper();

    void quit();

    void close();
}
