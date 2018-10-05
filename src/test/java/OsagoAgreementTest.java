import fixtures.AgreementFixtures;
import models.Agreement;
import org.testng.annotations.Test;
import pages.TestBase;

public class OsagoAgreementTest extends TestBase {

    @Test
    public void loginTest() {
        manager.getNavigationHelper().openBaseUrl();
        manager.getUserHelper().login();
        manager.getUserHelper().verifyLogin();
    }

    @Test
    public void technicalInspectionTest() {
        manager.getNavigationHelper().openBaseUrl();
        manager.getUserHelper().login();
        Agreement agreement = AgreementFixtures.getAgreement("agreement");
        manager.getUserHelper().fillVinNumber(agreement);
        manager.getUserHelper().verifyTO();
    }

    @Test
    public void documentsTest() {
        manager.getNavigationHelper().openBaseUrl();
        manager.getUserHelper().login();
        Agreement agreement = AgreementFixtures.getAgreement("agreement");
        manager.getUserHelper().fillVehicleComplete(agreement);
        manager.getUserHelper().verifyDocuments();
    }
}
