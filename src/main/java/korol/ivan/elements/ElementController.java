package korol.ivan.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementController {
    private List<String> getXPaths(String xPath) {
        return Arrays.asList(xPath.split("\\|"));
    }

    public List<String> getFormattedXPath(String xpath, String name) {
        List<String> temp = new ArrayList<String>();
        for (String xpathe : getXPaths(xpath)) {
            temp.add(String.format(xpathe, name));
        }
        return temp;
    }
}
