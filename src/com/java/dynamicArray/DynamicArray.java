package com.java.dynamicArray;

import com.java.common.MyAbstractList;

/**
 * @author: boris
 * @Date: 2020-01-09 23:28
 * @Description:
 */
public class DynamicArray<E> extends MyAbstractList<E> {

    private E[] elements;

    public DynamicArray(int capacity) {
        capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY :capacity;
        elements = (E[]) new Object[capacity];
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
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
//        for (int i = size - 1; i >= index; i--) {
//            elements[i + 1] = elements[i];
//        }
        // 相比上面减少运算
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        // 系统级别的数组赋值
        // System.arraycopy(elements, index, elements, index + 1, size - index);
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
        trim();
        return old;
    }

    // 删除某个元素
    public void remove(E element) {
        remove(indexOf(element));
    }

    // 查看元素的位置
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                // 自定义类可以重写类的equals
                /*
                @Override
                public boolean equals(Object obj) {
                    if (obj == null) return false;
                    if (obj instanceof Class) {
                        Class cls = (Class) obj;
                        return this.x = cls.x;
                    }
                    return false;
                }
                */
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
        // 缩容
        if(elements != null && elements.length > DEFAULT_CAPACITY) {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }
    }

    // 扩容
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

    // 缩容
    // 如果内存使用比较紧张，动态数组有比较多的剩余空间，可以考虑进行缩容操作
    // 比如剩余空间占总容量的一半时，就进行缩容（自己定义）
    // 如果扩容倍数、缩容时机设计不得当，有可能会导致复杂度震荡
    private void trim() {
        int capacity = elements.length;
        // 假定缩容一半
        int newCapacity = capacity >> 1;
        // 剩余空间不足一半，本身的容量又比默认小（发生在缩容后）
        if(size > newCapacity || capacity <= DEFAULT_CAPACITY) return;

        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
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
