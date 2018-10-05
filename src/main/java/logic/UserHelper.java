package logic;

import models.Agreement;

public interface UserHelper {

    void login();

    void fillVinNumber(Agreement agreement);

    void verifyLogin();

    void fillVehicleComplete(Agreement agreement);

    void verifyTO();

    void verifyDocuments();
}
