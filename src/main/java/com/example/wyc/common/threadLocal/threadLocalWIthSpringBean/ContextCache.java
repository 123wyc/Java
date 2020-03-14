package com.example.wyc.common.threadLocal.threadLocalWIthSpringBean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ContextCache implements Serializable {

    private static final long serialVersionUID = 2136539028591849277L;

    // 使用 ThreadLocal 缓存上下文信息
    public static final ThreadLocal<Map<String, String>> CACHE = new ThreadLocal<>();

    /**
     * 放数据
     *
     * @param sourceKey
     */
    public static final void putAttribute(String sourceKey, String value) {
        Map<String, String> cacheMap = CACHE.get();
        if (null == cacheMap) {
            cacheMap = new HashMap<>();
        }
        cacheMap.put(sourceKey, value);
        CACHE.set(cacheMap);
    }

    /**
     * 拿数据
     *
     * @param sourceKey
     */
    public static final String getAttribute(String sourceKey) {
        Map<String, String> cacheMap = CACHE.get();
        if (null == cacheMap) {
            return null;
        }
        return cacheMap.get(sourceKey);
    }

}
