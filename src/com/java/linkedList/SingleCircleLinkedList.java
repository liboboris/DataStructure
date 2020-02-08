package com.java.linkedList;

import com.java.common.MyAbstractList;

/**
 * @author: boris
 * @Date: 2020-01-24 17:51
 * @Description: 单向循环链表
 */
public class SingleCircleLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head;

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
            if(size == 0) {
                // size == 0,空表，插入后指向自己
                head = new Node<>(element, head);
                head.next = head;
            } else {
                // 最后一个节点
                Node<E> last = node(size - 1);
                head = new Node<>(element, head);
                last.next = head;
            }
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = head;
        if(index == 0)  {
            if(size == 1) {
                head = null;
            } else {
                Node<E> last = node(size - 1);
                head = head.next;
                last.next = head;
            }
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = prev.next.next;
        }
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
