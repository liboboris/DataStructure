package com.java.stack;

import com.java.common.MyList;
import com.java.dynamicArray.DynamicArray;

/**
 * @author: boris
 * @Date: 2020-02-12 22:34
 * @Description:
 */
public class MyStack<E> {
    private MyList<E> list = new DynamicArray<>();

    public int size() {
        return list.size();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void push(E element) {
        list.add(element);
    }
    public E pop() {
        return list.remove(list.size() - 1);
    }
    public E top() {
        return list.get(list.size() - 1);
    }
    public void clear() {
        list.clear();
    }
}
