package com.kimjuwon.soccer.exception;

import java.util.HashMap;
import java.util.Map;

public class NotFoundException extends RuntimeException {
    private Map<String, Object> map;

    public NotFoundException(String message) {
        map = new HashMap<String, Object>() {{
            put("error", new HashMap<String, Object>() {{
                put("message", message);
            }});
        }};
    }

    public Map<String, Object> getMap() {
        return map;
    }
}
