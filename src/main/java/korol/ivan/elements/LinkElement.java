package korol.ivan.elements;

import korol.ivan.util.LocatorsLocation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LinkElement extends ElementController implements Element {
    private WebDriver driver;

//    private static LinkElement instance;

    public LinkElement(WebDriver driver) {
        this.driver = driver;
    }

//    public static LinkElement getInstance(WebDriver driver) {
//        if (instance == null) {
//            instance = new LinkElement(driver);
//        }
//        return instance;
//    }


    public WebElement getWebElement(String elementName) {
        List<String> temp = getFormattedXPath(LocatorsLocation.LINK_XPATH, elementName);
        WebElement element = null;
        for (String aTemp : temp) {
            try {
                element = driver.findElement(By.xpath(aTemp));
                if (element.getText().equalsIgnoreCase(elementName)
                        || element.getAttribute("value").equalsIgnoreCase(elementName)) {
                    break;
                }
            } finally {
                continue;
            }
        }
        return element;
    }
}
