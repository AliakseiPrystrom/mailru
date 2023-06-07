package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonDataUtil {
    private final static String testDataFilePath = "src/test/resources/testdata.json";
    private final static String testUrlsPath = "src/test/resources/testurls.json";
    private static final Gson gson = new Gson();

    private static String getJsonString(String jsonFilePath, String key) {
        String value = "";
        try {
            FileReader reader = new FileReader(jsonFilePath);
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            value = jsonObject.get(key).toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String getValue(String filePath, String key) {
        String value = "";
        switch (filePath) {
            case ("testData"):
                value = gson.fromJson(getJsonString(testDataFilePath, key), String.class);
                break;
            case ("testUrl"):
                value = gson.fromJson(getJsonString(testUrlsPath, key), String.class);
                break;
        }
        return value;
    }
}
