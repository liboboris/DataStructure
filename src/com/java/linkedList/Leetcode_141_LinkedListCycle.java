package com.java.linkedList;

/**
 * @author: boris
 * @Date: 2020-01-13 00:23
 * @Description: 给定一个链表，判断链表中是否有环。
 *               为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 *               如果 pos 是 -1，则在该链表中没有环。
 *               输入：head = [3,2,0,-4], pos = 1
 *               输出：true
 *               解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class Leetcode_141_LinkedListCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
