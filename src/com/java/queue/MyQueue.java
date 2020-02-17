package com.java.queue;

import com.java.common.MyList;
import com.java.linkedList.MyDoubleLinkedList;

/**
 * @author: boris
 * @Date: 2020-02-15 22:25
 * @Description: 队列
 */
public class MyQueue<E> {
    // 使用双向列表存储数据
    private MyList<E> list = new MyDoubleLinkedList<>();

    // 元素的数量
    public int size() {
        return list.size();
    }

    // 是否为空
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // 入队
    public void enQueue(E element) {
        list.add(element);
    }

    // 出队
    public E deQueue() {
        return list.remove(0);
    }

    // 获取队列的头元素
    public E front() {
        return list.get(0);
    }

    // 清空
    public void clear() {
        list.clear();
    }
}
