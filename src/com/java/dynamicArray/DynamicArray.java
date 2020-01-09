package com.java.dynamicArray;

/**
 * @author: boris
 * @Date: 2020-01-09 23:28
 * @Description:
 */
public class DynamicArray  <E> {

    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArray(int capacity) {
        capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY :capacity;
        elements = (E[]) new Object[capacity];
    }

    // 返回元素的数量
    public int getSize() {
        return size;
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 是否包含某个元素
    public boolean contains(E element) {
        return false;
    }

    // 添加元素到最后面
    public void add(E element) {

    }

    // 返回index位置对应的元素
    public E get(int index) {
        return null;
    }

    // 设置index位置的元素
    public void set(int index, E element) {

    }

    // 往index位置添加元素
    public void add(int index, E element) {

    }

    // 删除index位置对应的元素
    public E remove(int index) {
        return null;
    }

    // 查看元素的位置
    public int indexOf(E element) {
        return 0;
    }

    // 清除所有元素
    public void clear() {

    }
}
