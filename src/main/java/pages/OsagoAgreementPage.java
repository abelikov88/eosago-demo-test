package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author abelikov
 */
public class OsagoAgreementPage extends Page {

    public OsagoAgreementPage(PageManager pages) {
        super(pages);
    }

    @FindBy(id = "car_mark")
    private WebElement carMark;

    @FindBy(id = "car_model")
    private WebElement carModel;

    @FindBy(id = "manufacturing_date")
    private WebElement year;

    @FindBy(id = "VIN")
    private WebElement vinRadioButton;

    @FindBy(css = "input[ng-reflect-ident-type-validator='VIN']")
    private WebElement vinInput;

    @FindBy(id = "number_plate")
    private WebElement stateNumber;

    @FindBy(id = "engine_power")
    private WebElement enginePower;

    @FindBy(id = "ts_series")
    private WebElement tsSeries;

    @FindBy(id = "ts_number")
    private WebElement tsNumber;

    @FindBy(id = "issue_date")
    private WebElement issueDate;

    @FindBy(xpath = "//ul/li[1]/div/h6")
    private WebElement assertTO;

    public OsagoAgreementPage selectMark(String mark) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("dropdownBasic1")));
        carMark.sendKeys(mark);
        carMark.sendKeys(Keys.ENTER);
        return this;
    }

    public OsagoAgreementPage selectModel(String model) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(carModel));
        carModel.sendKeys(model);
        carModel.sendKeys(Keys.ENTER);
        return this;
    }

    public OsagoAgreementPage selectYear(String year) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.year));
        this.year.sendKeys(year);
        this.year.sendKeys(Keys.ENTER);
        return this;
    }

    public OsagoAgreementPage setStateNumber(String number) {
        stateNumber.clear();
        stateNumber.sendKeys(number);
        return this;
    }

    public OsagoAgreementPage setVinInput(String vinNumber) {
        vinInput.clear();
        vinInput.sendKeys(vinNumber);
        return this;
    }

    public OsagoAgreementPage setEnginePower(String power) {
        enginePower.clear();
        enginePower.sendKeys(power);
        return this;
    }

    public OsagoAgreementPage setTsSeries(String series) {
        tsSeries.clear();
        tsSeries.sendKeys(series);
        return this;
    }

    public OsagoAgreementPage setTsNumber(String number) {
        tsNumber.clear();
        tsNumber.sendKeys(number);
        return this;
    }

    public OsagoAgreementPage setDate(String date) {
        issueDate.clear();
        issueDate.sendKeys(date);
        return this;
    }

    public void verifyTO() {
        new WebDriverWait(driver, 200).until((ExpectedCondition<Boolean>) driver
            -> driver.findElement(By.xpath("//ul/li[1]/div/h6")).getText().equals("ТО - проверено"));
        Assert.assertEquals("ТО - проверено", assertTO.getText());
    }

    public void verifyLogin() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("dropdownBasic1")));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://eosago-aggregator.2018-1.test.b2bpolis.ru/#/calculator");
    }

    public void verifyDocuments() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='active']")));
        WebElement active = driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(active.isEnabled());
    }
}
