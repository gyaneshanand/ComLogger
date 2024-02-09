package com.mbb.logger;

import java.util.Properties;

public class ComLoggerInitializer {

    private static final String COM_LOGGER_PROPERTIES = "com-logger.properties";

    public static boolean INITIALIZED;

    public static void initialize(String propertiesFile){
        if (!INITIALIZED) {
            System.out.printf("Initializing ComLogger with %s%n", COM_LOGGER_PROPERTIES);

            Properties properties = new Properties();
            ClassLoader classLoader = ComLoggerInitializer.class.getClassLoader();
            try {
                properties.load(classLoader.getResourceAsStream(COM_LOGGER_PROPERTIES));
                properties.stringPropertyNames().forEach(key -> {
                    System.setProperty(key, properties.getProperty(key));
                });
                INITIALIZED = true;
            } catch (Exception e) {
                System.err.printf("Failed to load com-logger properties and switching to defalut from %s%n", COM_LOGGER_PROPERTIES);
                e.printStackTrace();
            }
        }
    }

    public static void initialize(){
        initialize(COM_LOGGER_PROPERTIES);
    }
}
