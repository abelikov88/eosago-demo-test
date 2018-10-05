package helpers;

import logic.UserHelper;
import models.Agreement;

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
    public void fillVinNumber(Agreement agreement) {
        pages.osagoAgreementPage
            .setVinInput(agreement.getVinNumber());
    }

    @Override
    public void fillVehicleComplete(Agreement agreement) {
        pages.osagoAgreementPage
            .selectMark(agreement.getMark())
            .selectModel(agreement.getModel())
            .selectYear(agreement.getYear())
            .setVinInput(agreement.getVinNumber())
            .setStateNumber(agreement.getStateNumber())
            .setEnginePower(agreement.getEnginePower())
            .setTsSeries(agreement.getTsSeries())
            .setTsNumber(agreement.getTsNumber())
            .setDate(agreement.getDate());
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
