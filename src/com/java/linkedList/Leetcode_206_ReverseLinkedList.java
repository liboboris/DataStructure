package com.java.linkedList;

/**
 * @author: boris
 * @Date: 2020-01-12 18:38
 * @Description: 反转一个单链表。
 *              输入: 1->2->3->4->5->NULL
 *              输出: 5->4->3->2->1->NULL
 */
public class Leetcode_206_ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 递归
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = reverseList(head);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = null;
        while (head != null) {
            // 保存当前节点的指向节点
            ListNode tmp = head.next;
            // 当前节点指向翻转后的节点，第一个节点就是null
            head.next = newHead;
            // 末尾节点迁移当前节点，下次循环作为被指向的节点
            newHead = head;
            // 当前节点迁移下一个节点
            head = tmp;
        }
        return newHead;
    }
}
