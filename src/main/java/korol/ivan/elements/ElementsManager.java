package korol.ivan.elements;

import org.openqa.selenium.WebDriver;

public class ElementsManager {
    private WebDriver driver;

    public ElementsManager() {
    }

    public ElementsManager(WebDriver driver) {
        this.driver = driver;
    }

    public Element getElement(ElementEnum elementType) {
        switch (elementType) {
            case LINK:
                return LinkElement.getInstance(driver);
            case BUTTON:
                return ButtonElement.getInstance(driver);
            case TEXT_FIELD:
                return TextFieldElement.getInstance(driver);
            default:
                throw new IllegalArgumentException(
                        String.format("Element type %s is not found", elementType.toString())
                );
        }
    }

}
