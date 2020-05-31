package korol.ivan.util;

public class LocatorsLocation {
    private LocatorsLocation() {
    }

    public static final String LINK_XPATH = "//a[contains(@data-ga-click, '%s')]";

    public static final String BUTTON_XPATH = "//input[@value='%s']";

    public static final String TEXT_FIELD_XPATH = "//label[contains(text(),'%s')]/following-sibling::input[1]";
}
