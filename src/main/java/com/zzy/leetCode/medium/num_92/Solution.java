package com.zzy.leetCode.medium.num_92;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/3/18 10:22
 * <p>
 * 给你单链表的头节点head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);
        ListNode node_6 = new ListNode(6);
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        node_5.next = node_6;
        ListNode tmp = node_1;
        while (tmp != null) {
            System.out.print(tmp.val);
            tmp = tmp.next;
        }
        node_1 = new Solution().reverseBetween(node_1, 2, 5);
        tmp = node_1;
        while (tmp != null) {
            System.out.print(tmp.val);
            tmp = tmp.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        int record = 0;
        ListNode left_flag, medium_flag, right_flag, tmp = head;
        for (int i = 0; i < right; i++) {
            if (i == left - 2) {
                left_flag = tmp;
            } else if (i == left - 1) {
                medium_flag = tmp;
            }
            tmp = tmp.next;
        }
        return head;
    }
}

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