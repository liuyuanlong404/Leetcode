package com.rose.test;

/**
 * Created on 2021/10/14 10:52
 *
 * @author Rose
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 *
 */
public class Test15 {


    public ListDemo.ListNode removeNthFromEnd(ListDemo.ListNode head, int n) {
        return removeNode(head,n)==n?head.next:head;
    }

    public int removeNode(ListDemo.ListNode node, int n) {
        if(node.next == null) {
            return 1;
        }
        int m = removeNode(node.next, n);
        if(m == n) {
            if(m == 1) {
                node.next = null;
            } else {
                node.next = node.next.next;
            }
        }
        return m+1;
    }
}





