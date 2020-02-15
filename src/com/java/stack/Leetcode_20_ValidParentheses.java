package com.java.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author: boris
 * @Date: 2020-02-15 17:07
 * @Description: 有效的括号
 */
public class Leetcode_20_ValidParentheses {
     private static HashMap<Character, Character> map = new HashMap<Character, Character>() {
         {
             put('(', ')');
             put('{', '}');
             put('[', ']');
         }
     };

    // 不用数据结构
    // 效率低，字符查找和字符串替换都是比较耗性能的，字符串是不可变的字符串，同时又不断产生新的字符串，所以浪费内存
    public boolean isValidNds(String s) {
        while (s.contains("{}")
                || s.contains("[]")
                || s.contains("()")) {
            s = s.replace("{}", "");
            s = s.replace("[]", "");
            s = s.replace("()", "");
        }
        return s.isEmpty();
    }

    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                if(c != map.get(stack.pop())) return false;
            }
        }
        return stack.isEmpty();
    }
}
