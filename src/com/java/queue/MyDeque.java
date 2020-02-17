package com.java.queue;

import com.java.common.MyList;
import com.java.linkedList.MyDoubleLinkedList;

/**
 * @author: boris
 * @Date: 2020-02-16 17:45
 * @Description: 双端队列
 */
public class MyDeque<E> {
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

    // 从队尾入队
    public void enQueueRear(E element) {
        list.add(element);
    }

    // 从队头出队
    public E deQueueFront() {
        return list.remove(0);
    }

    // 从队头入队
    public void enQueueFront(E element) {
        list.add(0, element);
    }

    // 从队尾出队
    public E deQueueRear() {
        return list.remove(list.size() - 1);
    }

    // 获取队列的头元素
    public E front() {
        return list.get(0);
    }

    // 获取队尾的头元素
    public E rear() {
        return list.get(list.size() - 1);
    }

    // 清空
    public void clear() {
        list.clear();
    }
}
