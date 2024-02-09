package com.mbb.logger;

public class ComLoggerFactory {

    private ComLoggerFactory() {
    }

    public static ComLogger getLogger(Class<?> clazz) {
        return ComLogger.getInstance(clazz);
    }
}
