package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHelper {
    private static Properties properties;

    public static void initProperty(String fileName) {
        properties = new Properties();

        try {
            FileInputStream inputStream = new FileInputStream("C:\\P\\IntelliJ IDEA Community Edition 2021.3.1\\JavaPractical\\MySelenium\\src\\test\\resources\\" + fileName);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String name) {
        return properties.getProperty(name);
    }
}
