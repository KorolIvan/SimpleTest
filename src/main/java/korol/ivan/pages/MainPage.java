package korol.ivan.pages;

import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver drivar;

    public MainPage(WebDriver drivar) {
        this.drivar = drivar;
    }

    public void navigateToURL(String url) {
        drivar.get(url);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
