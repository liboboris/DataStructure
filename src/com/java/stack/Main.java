package com.java.stack;

/**
 * @author: boris
 * @Date: 2020-02-12 22:37
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
