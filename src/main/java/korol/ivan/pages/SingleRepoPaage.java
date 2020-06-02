package korol.ivan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SingleRepoPaage {
    private WebDriver driver;

    public SingleRepoPaage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isRepositoryExist(String repoName) {
        return driver.getTitle().endsWith(repoName);
    }

    public boolean isRepositoryIsNotExist(String repoName) {
        return driver.getTitle().contains("Page not found");
    }
}
