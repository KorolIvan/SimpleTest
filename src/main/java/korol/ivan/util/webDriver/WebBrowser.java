package korol.ivan.util.webDriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class WebBrowser {
    private WebDriver driver;
    private Process executingPermission;
    private static String pathToDrivers = new File("src/main/resources/drivers/").getAbsolutePath();

    //path to browsers drivers for windows os
    private static final String CHROME_DRIVER_PATH = pathToDrivers + "/win/chromedriver.exe";

    //path to browsers drivers for linux os
    private static final String CHROME_DRIVER_PATH_LINUX = pathToDrivers + "/linux/chromedriver";

    //this commands will run before set the browser to run
    private static String executePermission = "chmod +x ";

    private String operationSystem() {
        return OSSystem.getOs();
    }

    public WebDriver getDriver() throws IOException {
        String s = operationSystem();
        if ("windows".equals(s)) {
            return getDriverForWindows();
        } else if ("linux".equals(s)) {
            return getDriverForLinux();
        }

        throw new IllegalArgumentException(
            String.format("Cannot start browser session under system %s", operationSystem())
        );
    }

    private WebDriver getDriverForWindows() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1366, 900));
        return driver;
    }

    private WebDriver getDriverForLinux() throws IOException {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH_LINUX);
        executingPermission = Runtime.getRuntime().exec(executePermission
                + CHROME_DRIVER_PATH_LINUX);
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1366, 900));
        return driver;
    }
}
