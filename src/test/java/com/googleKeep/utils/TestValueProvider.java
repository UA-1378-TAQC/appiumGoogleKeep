package com.googleKeep.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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

    private String getRequiredConfigValue(String propertyKey, String envKey) {
        String value = properties != null
                ? properties.getProperty(propertyKey)
                : System.getenv(envKey);

        if (value == null || value.trim().isEmpty()) {
            throw new RuntimeException(
                    String.format("Required configuration missing! Property: '%s' or Env: '%s'",
                            propertyKey, envKey)
            );
        }
        return value;
    }

    public Duration getImplicitlyWait() {
        return Duration.ofSeconds(Long.parseLong(getRequiredConfigValue("implicitlyWait", "IMPLICITLY_WAIT")));
    }

    public String getAppiumServerURL() {
        return getRequiredConfigValue("appiumServerURL", "APPIUM_SERVER_URL");
    }

    public String getPlatformName() {
        return getRequiredConfigValue("platformName", "PLATFORM_NAME");
    }

    public String getPlatformVersion() {
        return getRequiredConfigValue("platformVersion", "PLATFORM_VERSION");
    }

    public String getDeviceName() {
        return getRequiredConfigValue("deviceName", "DEVICE_NAME");
    }

    public String getAutomationName() {
        return getRequiredConfigValue("automationName", "AUTOMATION_NAME");
    }

    public String getAppPackage() {
        return getRequiredConfigValue("appPackage", "APP_PACKAGE");
    }

    public String getAppActivity() {
        return getRequiredConfigValue("appActivity", "APP_ACTIVITY");
    }

}
