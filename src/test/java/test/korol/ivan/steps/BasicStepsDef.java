package test.korol.ivan.steps;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import korol.ivan.elements.ElementEnum;
import korol.ivan.elements.ElementsManager;
import korol.ivan.pages.DashboardPage;
import korol.ivan.pages.LoginPage;
import korol.ivan.pages.MainPage;
import korol.ivan.util.webDriver.WebBrowser;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static korol.ivan.util.DataSaver.getSavedDataOrReturnSelf;


public class BasicStepsDef {
    private static WebDriver driver;

    private MainPage mainPage;
    private LoginPage loginPage;
    private ElementsManager elementsManager;
    private DashboardPage dashboardPage;

    public BasicStepsDef() {
    }

    @Before
    public void setUp() throws IOException {
        driver = new WebBrowser().getDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);

        elementsManager = new ElementsManager(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Given("^I navigate to \"(.+)\"$")
    public void navigateTo (String url) {
        mainPage.navigateToURL(url);
    }

    @When("^I click on \"(.+)\" link$")
    public void clickOnElement(String elementName) {
        elementsManager.getElement(ElementEnum.LINK).getWebElement(elementName).click();
    }

    @When("^I enter \"(.+)\" to \"(.+)\" field$")
    public void enterTextToTheField(String value, String elementLabel) {
        System.out.println(getSavedDataOrReturnSelf(value));
        elementsManager
                .getElement(ElementEnum
                        .TEXT_FIELD)
                .getWebElement(elementLabel)
                .sendKeys(getSavedDataOrReturnSelf(value));
    }

    @When("^I click on \"(.+)\" button$")
    public void clickOnButtonWithSpecificName(String buttonName) {
        elementsManager.getElement(ElementEnum.BUTTON).getWebElement(buttonName).click();
    }

    @Then("^user successfully logged into the system$")
    public void verifyThatUserSuccessfullyLoggedIn() {
        Assert.assertEquals("Dashboard", dashboardPage.isItDashboardPage());
    }

}
