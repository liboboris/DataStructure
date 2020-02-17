package com.java.queue;

import java.util.Stack;

/**
 * @author: boris
 * @Date: 2020-02-16 16:55
 * @Description: 使用栈实现队列
 */
public class Leetcode_232 {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    /**
     * initialize your data structure here
     */
    public Leetcode_232() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * push element x to the back of queue
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * removes the element from in front of queue and returns that element
     */
    public int pop() {
        checkOutStack();
        return outStack.pop();
    }

    /**
     * get the front element
     */
    public int peek() {
        checkOutStack();
        return outStack.peek();
    }

    /**
     * returns whether the queue is empty
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void checkOutStack() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
