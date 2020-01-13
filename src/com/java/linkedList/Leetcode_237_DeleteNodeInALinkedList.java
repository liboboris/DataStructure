package com.java.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: boris
 * @Date: 2020-01-12 18:25
 * @Description: 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 *              输入: head = [4,5,1,9], node = 5
 *              输出: [4,1,9]
 *              解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class Leetcode_237_DeleteNodeInALinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
