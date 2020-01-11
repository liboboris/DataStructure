package com.java.dynamicArray;

import com.java.common.Assert;

/**
 * @author: boris
 * @Date: 2020-01-09 23:28
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.add(88);
        array.add(77);
        array.add(66);
        array.add(55);
        System.out.println(array);
        array.set(3, 80);
        System.out.println(array);
        Assert.test(array.get(3) == 81);
        array.remove(2);
        System.out.println(array);
        for (int i = 0; i < 40; i++) {
            array.add(i);
        }
        System.out.println(array);
    }
}
