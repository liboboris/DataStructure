package com.java.common;

/**
 * @author: boris
 * @Date: 2020-01-11 05:15
 * @Description: 测试验证
 */
public class Assert {
    public static void test(boolean value) {
        try {
            if (!value) throw new Exception("Test failed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
