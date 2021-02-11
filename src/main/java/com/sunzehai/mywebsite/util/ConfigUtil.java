package com.sunzehai.mywebsite.util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigUtil {

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(ConfigUtil.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException ex) {
            throw new RuntimeException("Could not load application.properties", ex);
        }
    }

    public static Path getArticlesPath() {
        return Paths.get(properties.getProperty("articles.path"));
    }

}
