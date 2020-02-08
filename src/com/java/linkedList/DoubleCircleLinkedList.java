package com.java.linkedList;

import com.java.common.MyAbstractList;

/**
 * @author: boris
 * @Date: 2020-02-08 22:30
 * @Description: 双向循环链表
 */
public class DoubleCircleLinkedList<E> extends MyAbstractList<E> {
    // 指向头结点
    private Node<E> head;
    // 指向尾结点
    private Node<E> end;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        // 可以验证clear时是否清空对象
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("Node - finalize");
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if(prev != null) {
                stringBuilder.append(prev.element);
            } else {
                stringBuilder.append("null");
            }
            stringBuilder.append("_").append(element).append("_");
            if(next != null) {
                stringBuilder.append(next.element);
            } else {
                stringBuilder.append("null");
            }
            return stringBuilder.toString();
        }
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        end = null;
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
    // 在index前插入
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if(index == size) {
            // 添加至末尾

            // 之前最后一个节点
            Node<E> last = end;
            end = new Node<>(element, last, head);
            if(last == null) {
                // 链表之前为空，这是添加的第一个元素
                head = end;
                head.next = head;
                head.prev = head;
            } else {
                last.next = end;
                head.prev = end;
            }
        } else {
            // 找到指定的元素
            Node<E> node = node(index);
            Node<E> prev = node.prev;
            Node<E> newNode = new Node<>(element, prev, node);
            prev.next = newNode;
            if (node == head) {
                // index == 0
                head = newNode;
            }

            node.prev = newNode;
        }

        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        // 设置初始值为头结点
        Node<E> node = head;
        if (size == 1) {
            head = null;
            end = null;
        } else {
            node = node(index);
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            if (node == head) {
                // 删除第一个节点
                head = next;
            }

            next.prev = prev;
            if (node == end) {
                // 删除末尾节点
                end = prev;
            }
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
        if(index < (size >> 1)) {
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = end;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", [");
        Node<E> node = head;
        for (int i = 0; i < size ; i++) {
            if (i != 0) stringBuilder.append(", ");
            stringBuilder.append(node);
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
