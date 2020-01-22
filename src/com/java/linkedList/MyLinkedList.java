package com.java.linkedList;

import com.java.common.MyAbstractList;

/**
 * @author: boris
 * @Date: 2020-01-11 21:45
 * @Description: 单向链表
 */
public class MyLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head;
    // 虚拟头结点
    private Node<E> v_head;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        // 可以验证clear时是否清空对象
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("Node - finalize");
        }
    }

    // 针对虚拟节点
    public MyLinkedList() {
        v_head = new Node<>(null,null);
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if(index == 0) {
            head = new Node<>(element, head);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    // 添加哨兵，虚拟头结点
    public void v_add(int index, E element) {
        rangeCheckForAdd(index);
        Node<E> prev = index == 0 ? v_head : v_node(index - 1);
        prev.next = new Node<>(element, prev.next);
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = head;
        if(index == 0)  {
            head = head.next;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = prev.next.next;
        }
        size--;
        return node.element;
    }

    // 添加哨兵，虚拟头结点
    public E v_remove(int index) {
        rangeCheck(index);
        Node<E> prev = index == 0 ? v_head : v_node(index - 1);
        Node<E> node = prev.next;
        prev.next = node.next;
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = head;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private Node<E> v_node(int index) {
        rangeCheck(index);
        Node<E> node = v_head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", [");
        Node<E> node = head;
        for (int i = 0; i < size ; i++) {
            if (i != 0) stringBuilder.append(", ");
            stringBuilder.append(node.element);
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
