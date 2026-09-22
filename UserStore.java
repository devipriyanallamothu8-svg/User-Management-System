package com.user;

import java.util.HashMap;
import java.util.Map;

public class UserStore {

    public static final Map<String, String> users =
            new HashMap<String, String>();

    static {
        users.put("admin", "1234");
    }
}
