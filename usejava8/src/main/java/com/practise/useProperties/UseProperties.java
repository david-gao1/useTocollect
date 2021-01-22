package com.practise.useProperties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UseProperties {

    private static final Map<String, String> PROPERTIES_CACHE = new HashMap<>();

    /**
     * 1、加载文件（key：value）
     * 2、由key获取映射值
     * @param key
     * @return
     */
    public static String getCustomPropertyValue(String key) {
        String value = PROPERTIES_CACHE.get(key);
        if (value != null) {
            return value;
        }
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("tbds_utils.properties"));
            String property = properties.getProperty(key);
            PROPERTIES_CACHE.put(key, property);
            return property;
        } catch (IOException e) {
            return null;
        }
    }
}
