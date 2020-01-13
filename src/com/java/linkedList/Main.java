package com.java.linkedList;

import com.java.common.MyList;

/**
 * @author: boris
 * @Date: 2020-01-12 18:06
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyLinkedList<>();
        myList.add(20);
        myList.add(0, 10);
        myList.add(30);
        myList.add(myList.size(), 40);
        System.out.println(myList);
        myList.remove(1);
        System.out.println(myList);
    }
}
