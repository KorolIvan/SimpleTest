package test.korol.ivan.steps;

import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import korol.ivan.api.specification.RepositorySpecification;
import korol.ivan.elements.ElementEnum;
import korol.ivan.elements.ElementsManager;
import korol.ivan.model.Repository;
import korol.ivan.pages.DashboardPage;
import korol.ivan.pages.LoginPage;
import korol.ivan.pages.MainPage;
import korol.ivan.pages.SingleRepoPaage;
import korol.ivan.util.DataSaver;
import korol.ivan.util.webDriver.WebBrowser;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static korol.ivan.util.DataSaver.getSavedDataOrReturnSelf;


public class BasicStepsDef {
    private static WebDriver driver;

    private Repository repository;

    private MainPage mainPage;
    private LoginPage loginPage;
    private ElementsManager elementsManager;
    private DashboardPage dashboardPage;
    private SingleRepoPaage singleRepoPaage;
    private RepositorySpecification repositorySpecification;

    public BasicStepsDef() {
    }

    @Before
    public void setUp() throws IOException {
        driver = new WebBrowser().getDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        singleRepoPaage = new SingleRepoPaage(driver);

        repositorySpecification = new RepositorySpecification();

        repository = new Repository();

        elementsManager = new ElementsManager(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("^I navigate to \"(.+)\"$")
    public void navigateTo(String url) {
        mainPage.navigateToURL(url);
    }

    @When("^I click on \"(.+)\" link$")
    public void clickOnElement(String elementName) {
        elementsManager.getElement(ElementEnum.LINK).getWebElement(elementName).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^I enter \"(.+)\" to \"(.+)\" field$")
    public void enterTextToTheField(String value, String elementLabel) {
        elementsManager
                .getElement(ElementEnum
                        .TEXT_FIELD)
                .getWebElement(elementLabel)
                .sendKeys(getSavedDataOrReturnSelf(value));
    }

    @When("^I click on \"(.+)\" button$")
    public void clickOnButtonWithSpecificName(String buttonName) {
        elementsManager.getElement(ElementEnum.BUTTON).getWebElement(buttonName).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^user successfully logged into the system$")
    public void verifyThatUserSuccessfullyLoggedIn() {
        Assert.assertEquals("Dashboard", dashboardPage.isItDashboardPage());
    }

    @When("^I create new repository with name \"(.+)\"$")
    public void createNewRepository(String repoName) {
        repository.setName(repoName);
        RequestSpecification request =
                given().log().all()
                        .spec(repositorySpecification.creatNewRepo())
                        .body(repository);
        ValidatableResponse response =
                request
                        .when()
                        .post()
                        .then()
                        .assertThat()
                        .assertThat()
                        .statusCode(201);

    }

    @Then("^repository \"(.+)\" created successfully$")
    public void verifyThatRepositoryWasCreatedSuccessfuly(String repoName) {
        driver.get(driver.getCurrentUrl() + "/"
                + DataSaver.getSavedDataOrReturnSelf("gitHubUsername") + "/"
                + repoName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(singleRepoPaage.isRepositoryExist(repoName));
    }

    @Given("^I delete repository with name \"(.+)\"$")
    public void deleteReposytoryWithSpecificName(String repoName) {
        RequestSpecification request =
                given().log().all()
                        .spec(repositorySpecification.deleteRepository(repoName));
        ValidatableResponse response =
                request
                        .when()
                        .delete()
                        .then()
                        .assertThat()
                        .statusCode(204);
    }

    @Then("^repository \"(.+)\" deleted successfully$")
    public void isRepositeryDeletedSuccessfuly(String repoName) {
        driver.get(driver.getCurrentUrl() + "/"
                + DataSaver.getSavedDataOrReturnSelf("gitHubUsername") + "/"
                + repoName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(singleRepoPaage.isRepositoryIsNotExist(repoName));
    }

}
