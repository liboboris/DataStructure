package com.java.queue;

/**
 * @author: boris
 * @Date: 2020-02-15 22:26
 * @Description:
 */
public class Main {

    static void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enQueue(11);
        queue.enQueue(22);
        queue.enQueue(33);
        queue.enQueue(44);
        while (!queue.isEmpty()) {
            System.out.println("front: " + queue.front());
            System.out.println("deQueue: " + queue.deQueue());
        }
    }

    static void testMyDeque() {
        MyDeque<Integer> deque = new MyDeque<>();
        deque.enQueueFront(11);
        deque.enQueueRear(22);
        deque.enQueueFront(33);
        deque.enQueueRear(44);
        System.out.println("front: " + deque.deQueueFront());
        System.out.println("rear: " + deque.deQueueRear());
        System.out.println("front: " + deque.deQueueFront());
        System.out.println("rear: " + deque.deQueueRear());
    }

    static void testMyCircleQueue() {
        MyCircleQueue<Integer> circleQueue = new MyCircleQueue<>();
        for (int i = 0; i < 10; i++) {
            circleQueue.enQueue(i);
        }
        for (int i = 0; i < 5; i++) {
            circleQueue.deQueue();
        }
        System.out.println(circleQueue);
        for (int i = 15; i < 21; i++) {
            circleQueue.enQueue(i);
        }
        System.out.println(circleQueue);
        while (!circleQueue.isEmpty()) {
            System.out.println(circleQueue.deQueue());
        }
        circleQueue.clear();
        System.out.println(circleQueue);
    }

    static void testMyCircleDeque() {
        MyCircleDeque<Integer> circleDeque = new MyCircleDeque<>();
        for (int i = 0; i < 10; i++) {
            circleDeque.enQueueFront(i + 1);
            System.out.println("enfront:" + circleDeque);
            circleDeque.enQueueRear(i + 100);
            System.out.println("enrear:" + circleDeque);
        }

        System.out.println(circleDeque);
        for (int i = 0; i < 3; i++) {
            circleDeque.deQueueFront();
            circleDeque.deQueueRear();
        }
        System.out.println("deque:" + circleDeque);

        circleDeque.enQueueFront(11);
        circleDeque.enQueueFront(12);
        System.out.println("enfront:" + circleDeque);
        while (!circleDeque.isEmpty()) {
            System.out.println(circleDeque.deQueueFront());
        }
    }

    public static void main(String[] args) {
        //testMyDeque();
        //testMyDeque();
        //testMyCircleQueue();
        testMyCircleDeque();
    }
}
