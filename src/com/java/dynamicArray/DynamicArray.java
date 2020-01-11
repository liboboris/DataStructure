package com.java.dynamicArray;

import java.util.Objects;

/**
 * @author: boris
 * @Date: 2020-01-09 23:28
 * @Description:
 */
public class DynamicArray  <E> {

    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public DynamicArray(int capacity) {
        capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY :capacity;
        elements = (E[]) new Object[capacity];
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
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
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    // 添加元素到最后面
    public void add(E element) {
        //elements[size++] = element;
        add(size, element);
    }

    // 返回index位置对应的元素
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    // 设置index位置的元素
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    // 往index位置添加元素
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    // 删除index位置对应的元素
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        // 将最后一个元素置空，数组长度同时减1
        elements[--size] = null;
        return old;
    }

    // 查看元素的位置
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                // 自定义类需要重写类的equals
                if (element.equals(elements[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    // 清除所有元素
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    private void rangeCheck(int index) {
        if(index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    private void rangeCheckForAdd(int index) {
        if(index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        // 扩容1.5
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + ", expands: " + newCapacity);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", [");
        for (int i = 0; i < size ; i++) {
            if (i != 0) stringBuilder.append(", ");
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
