package korol.ivan.elements;

import org.openqa.selenium.WebDriver;

public class ElementsManager {
    private WebDriver driver;

    private LinkElement linkElement;
    private ButtonElement buttonElement;
    private TextFieldElement textFieldElement;


    public ElementsManager(WebDriver driver) {
        this.driver = driver;
        linkElement = new LinkElement(driver);
        textFieldElement = new TextFieldElement(driver);
        buttonElement = new ButtonElement(driver);
    }

    public Element getElement(ElementEnum elementType) {
        switch (elementType) {
            case LINK:
                return linkElement;
            case BUTTON:
                return buttonElement;
            case TEXT_FIELD:
                return textFieldElement;
            default:
                throw new IllegalArgumentException(
                        String.format("Element type %s is not found", elementType.toString())
                );
        }
    }

}
