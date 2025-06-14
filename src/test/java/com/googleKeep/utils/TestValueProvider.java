package com.coffeecart.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestValueProvider {
    Properties properties;

    public TestValueProvider() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException err) {
            System.out.println(err.getMessage());
            System.out.println("Use system env");
        }
    }

    private static List<String> stringToList(String input) {
        List<String> result = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            return result;
        }

        String[] parts = input.split(", ");
        for (String part : parts) {
            result.add(part.trim()); // Trim to remove leading/trailing spaces
        }

        return result;
    }

    public String getBaseUIUrl() {
        return properties != null ? properties.getProperty("base.ui.url") : System.getenv("BASE_UI_URL");
    }

    public int getImplicitlyWait() {
        return properties != null ? Integer.parseInt(properties.getProperty("implicitlyWait")) : Integer.parseInt(System.getenv("IMPLICITLY_WAIT"));
    }

    public String getUserEmail() {
        return properties != null ? properties.getProperty("user.email") : System.getenv("USER_EMAIL");
    }

    public String getUserName() {
        return properties != null ? properties.getProperty("user.name") : System.getenv("USER_NAME");
    }

}
