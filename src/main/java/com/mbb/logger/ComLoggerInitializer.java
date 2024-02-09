package com.mbb.logger;

import java.util.Properties;

public class ComLoggerInitializer {

    private static final String MBB_LOGGER_PROPERTIES = "mbb-logger.properties";

    public static boolean INITIALIZED;

    public static void initialize(String propertiesFile){
        if (!INITIALIZED) {
            System.out.printf("Initializing MbbLogger with %s%n", MBB_LOGGER_PROPERTIES);

            Properties properties = new Properties();
            ClassLoader classLoader = ComLoggerInitializer.class.getClassLoader();
            try {
                properties.load(classLoader.getResourceAsStream(MBB_LOGGER_PROPERTIES));
                properties.stringPropertyNames().forEach(key -> {
                    System.setProperty(key, properties.getProperty(key));
                });
                INITIALIZED = true;
            } catch (Exception e) {
                System.err.printf("Failed to load mbb-logger properties and switching to defalut from %s%n", MBB_LOGGER_PROPERTIES);
                e.printStackTrace();
            }
        }
    }

    public static void initialize(){
        initialize(MBB_LOGGER_PROPERTIES);
    }
}
