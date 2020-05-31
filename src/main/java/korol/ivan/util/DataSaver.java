package korol.ivan.util;

import java.util.HashMap;
import java.util.Map;

public class DataSaver {
    private static Map<String, String> data = new HashMap<>();

    public static void saveData(String key, String value) {
        data.putIfAbsent(key, value);
    }


    public static String getSavedDataOrReturnSelf(String key) {
        return data.getOrDefault(key, key);
    }

}
