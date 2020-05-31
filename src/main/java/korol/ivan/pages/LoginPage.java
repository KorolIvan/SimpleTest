package korol.ivan.pages;

import korol.ivan.model.GitHubUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private GitHubUser gitHubUser;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        gitHubUser = new GitHubUser();
        PageFactory.initElements(driver, this);
    }

}
