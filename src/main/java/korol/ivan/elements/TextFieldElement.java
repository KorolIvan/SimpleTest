package korol.ivan.elements;

import korol.ivan.util.LocatorsLocation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TextFieldElement extends ElementController implements Element {
    private WebDriver driver;

    public TextFieldElement(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getWebElement(String elementName) {
        List<String> temp = getFormattedXPath(LocatorsLocation.TEXT_FIELD_XPATH, elementName);
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
