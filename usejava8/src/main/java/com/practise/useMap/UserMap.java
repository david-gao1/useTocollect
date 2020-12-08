package com.practise.useMap;

import java.util.HashMap;
import java.util.Map;

public class UserMap {
    private static final Map<String, String> TARGET_TYPE_RELATIONS = new HashMap<String, String>() {{
        put(Constants.APPROVE_DETAIL_RESOURCE, "RESOURCE");
        put(Constants.APPROVE_DETAIL_HIVE, "DT");
        put(Constants.APPROVE_DETAIL_DT, "DT");
        put(Constants.APPROVE_DETAIL_MW, "MW");
    }};

    public static void main(String[] args) {
        //获取映射的或者是设置的默认值
        final String orDefault = TARGET_TYPE_RELATIONS.getOrDefault("PROJECT_REGISTRATION", "PROJECT_REGISTRATION");
        System.out.println(orDefault);

    }
}
