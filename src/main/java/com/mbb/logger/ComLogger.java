package com.mbb.logger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComLogger {

    private Logger logger;

    private ComLogger() {
    }

    private static class MbbLoggerHolder {
        private static final ComLogger INSTANCE = new ComLogger();
    }

    public static ComLogger getInstance(Class<?> clazz) {
        ComLogger mbbLogger = MbbLoggerHolder.INSTANCE;
        mbbLogger.logger = LoggerFactory.getLogger(clazz);
        return mbbLogger;
    }

    private void initialze(Class<?> clazz){
        try{
            System.setProperty("logging.config", "log4j2.xml");

            if (!ComLoggerInitializer.INITIALIZED)
                ComLoggerInitializer.initialize();

            logger = LoggerFactory.getLogger(clazz);

        } catch (Exception e) {
            System.out.println("Failed to initialize logger.");
        }
    }

//    public static MbbLogger getInstance(Class<?> clazz) {
//        MbbLogger mbbLogger = MbbLoggerHolder.INSTANCE;
//        mbbLogger.initialze(clazz);
//        return mbbLogger;
//    }

    public void info(String message) {
        logger.info(message);
    }

    public void info(String message, Object... args) {
        logger.info(message, args);
    }

    public void info(String message, Throwable throwable) {
        logger.info(message, throwable);
    }

    public void info(String message, Throwable throwable, Object... args) {
        logger.info(message, throwable, args);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void debug(String message, Object... args) {
        logger.debug(message, args);
    }

    public void debug(String message, Throwable throwable) {
        logger.debug(message, throwable);
    }

    public void debug(String message, Throwable throwable, Object... args) {
        logger.debug(message, throwable, args);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void warn(String message, Object... args) {
        logger.warn(message, args);
    }

    public void warn(String message, Throwable throwable) {
        logger.warn(message, throwable);
    }

    public void warn(String message, Throwable throwable, Object... args) {
        logger.warn(message, throwable, args);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void error(String message, Object... args) {
        logger.error(message, args);
    }

    public void logRequest(Object object) {
        logger.info("Request - {}" + object.toString());
    }

    public void logResponse(Object object) {
        logger.info("Response - {}" + object.toString());
    }

}
