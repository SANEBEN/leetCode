package com.zzy.leetCode.hard.num_23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/3/19 16:12
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode();

        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);
        ListNode node_6 = new ListNode(6);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));

        queue.add(node_1);
        queue.add(node_2);
        queue.add(node_3);
        queue.add(node_4);
        queue.add(node_5);
        queue.add(node_6);

        ListNode node = queue.peek();
        node = queue.poll();
        System.out.println();

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, tmp_1 = null, tmp_2;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            if (head == null) {
                head = queue.poll();
                queue.add(head.next);
            }
            if (tmp_1 == null) {
                tmp_1 = queue.poll();
                head.next = tmp_1;
                queue.add(tmp_1.next);
            }
            tmp_2 = queue.poll();
            tmp_1.next = tmp_2;
            tmp_1 = tmp_2;
            if (tmp_2.next != null) {
                queue.add(tmp_2.next);
            }
        }
        return head;
    }
}
