package helpers;

import logic.UserHelper;

/**
 * @author abelikov
 */
public class UserHelperImpl extends DriverHelper implements UserHelper {

    public UserHelperImpl(ManagerImpl manager) {
        super(manager.getWebDriver());
    }

    @Override
    public void login() {
        pages.loginPage
            .setLogin("test@tuk.ru")
            .setPassword("test@tuk.ru")
            .clickSubmitButton();
    }

    @Override
    public void fillVinNumber() {
        pages.osagoAgreementPage
            .setVinInput("WAUZZZ8T4BA037241");
    }

    @Override
    public void fillVehicleComplete() {
        pages.osagoAgreementPage
            .selectMark("Audi")
            .selectModel("A5")
            .selectYear("2010")
            .setVinInput("WAUZZZ8T4BA037241")
            .setStateNumber("Р904МХ178")
            .setEnginePower("211")
            .setTsSeries("78УН")
            .setTsNumber("267461")
            .setDate("01.11.2010");
    }

    @Override
    public void verifyLogin() {
        pages.osagoAgreementPage.verifyLogin();
    }

    @Override
    public void verifyTO() {
        pages.osagoAgreementPage.verifyTO();
    }

    @Override
    public void verifyDocuments() {
        pages.osagoAgreementPage.verifyDocuments();
    }
}
