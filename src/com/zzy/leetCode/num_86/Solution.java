package com.zzy.leetCode.num_86;

/**
 * @author 曾昭阳
 * @date 2021/1/3
 *
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 */
public class Solution {

    public static void main(String[] args) {
        ListNode num_1 = new ListNode(1);
        ListNode num_2 = new ListNode(4);
        ListNode num_3 = new ListNode(3);
        ListNode num_4 = new ListNode(2);
        ListNode num_5 = new ListNode(5);
        ListNode num_6 = new ListNode(2);
        num_1.next = num_2;
        num_2.next = num_3;
        num_3.next = num_4;
        num_4.next = num_5;
        num_5.next = num_6;
        Solution solution = new Solution();
        ListNode result = solution.partition(num_1, 3);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode little = null, big = null, little_tmp = null, big_tmp = null;
        while (head != null) {
            if (head.val < x) {
                if (little == null) {
                    little = new ListNode(head.val);
                    little_tmp = little;
                } else {

                    little_tmp.next = new ListNode(head.val);
                    little_tmp = little_tmp.next;
                }
            } else {
                if (big == null) {
                    big = new ListNode(head.val);
                    big_tmp = big;
                } else {
                    big_tmp.next = new ListNode(head.val);
                    big_tmp = big_tmp.next;
                }
            }
            head = head.next;
        }
        if(little_tmp == null){
            return big;
        }else {
            little_tmp.next = big;
            return little;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
