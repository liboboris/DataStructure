package com.java.queue;

import static com.java.common.MyList.DEFAULT_CAPACITY;

/**
 * @author: boris
 * @Date: 2020-02-16 18:17
 * @Description:
 */
public class MyCircleQueue<E> {
    private int size;
    private E[] elements;
    private int front;

    // 默认10个
    public MyCircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    // 元素的数量
    public int size() {
        return size;
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 入队
    public void enQueue(E element) {
        ensureCapcity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    // 出队
    public E deQueue() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    // 获取队列的头元素
    public E front() {
        return elements[front];
    }

    // 清空
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        size = 0;
        front = 0;
        // 缩容
        if(elements != null && elements.length > DEFAULT_CAPACITY) {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("capcacity=")
                .append(elements.length)
                .append(", size=").append(size)
                .append(", front=").append(front)
                .append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) stringBuilder.append(", ");
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private void ensureCapcity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        // 扩容1.5
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        // 重置front
        front = 0;
        System.out.println(oldCapacity + ", expands: " + newCapacity);
    }

    // 获取索引
    private int index(int index) {
        // m > 0, n >= 0, n < 2m
        // 这种效率高
        // System.out.println(n - (n >= m ? m : 0));
        // return (front + index) % elements.length;
        index += front;
        return index - (index >= elements.length ? elements.length : 0);
    }
}
