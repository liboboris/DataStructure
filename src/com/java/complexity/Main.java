package com.java.complexity;

import com.java.common.TimeTool;

/**
 * @author: boris
 * @Date: 2020-01-09 23:20
 * @Description:
 *              时间复杂度（time complexity）：估算程序指令的执行次数（执行时间）
 *              空间复杂度（space complexity）：估算所需占用的存储空间
 */
public class Main {

    public static long recursiveFib(int n) {
        if (n <= 1) return n;
        return recursiveFib(n-1) +recursiveFib(n-2);
    }

    public static long fib(int n) {
        if (n <= 1) return n;
        long first = 0;
        long second = 1;
        for(int i = 0; i < n -1; i ++) {
            long sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static void main(String[] args) {
        TimeTool.check("recursiveFib", () -> System.out.println(recursiveFib(45)));
        TimeTool.check("fib", () -> System.out.println(fib(45)));
    }
}
