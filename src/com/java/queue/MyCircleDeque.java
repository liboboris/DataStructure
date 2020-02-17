package com.java.queue;

import static com.java.common.MyList.DEFAULT_CAPACITY;

/**
 * @author: boris
 * @Date: 2020-02-17 11:48
 * @Description: 循环双端队列
 */
public class MyCircleDeque<E> {

    private int size;
    private E[] elements;
    private int front;

    // 默认10个
    public MyCircleDeque() {
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

    // 从队尾入队
    public void enQueueRear(E element) {
        ensureCapcity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    // 从队头出队
    public E deQueueFront() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    // 从队头入队
    public void enQueueFront(E element) {
        ensureCapcity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;
    }

    // 从队尾出队
    public E deQueueRear() {
        int rear = index(size - 1);
        E rearElement = elements[rear];
        elements[rear] = null;
        size--;
        return rearElement;
    }

    // 获取队列的头元素
    public E front() {
        return elements[front];
    }

    // 获取队尾的头元素
    public E rear() {
        return elements[index(size - 1)];
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
        int len = elements.length;
        index += front;
        index = index < 0 ? index + len : index;
        //return index % len;
        return index - (index >= elements.length ? elements.length : 0);
    }
}
