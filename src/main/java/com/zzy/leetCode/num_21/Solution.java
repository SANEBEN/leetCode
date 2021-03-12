package com.zzy.leetCode.num_21;

/**
 * @author 曾昭阳
 * @date 2020/7/12 15:49
 * <p>
 * 21. 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution {

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(new Solution().mergeTwoLists(null, l2).toString());
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode temp = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (root == null) {
                    root = new ListNode(l1.val);
                    temp = root;
                } else {
                    root.next = new ListNode(l1.val);
                    root = root.next;
                }
                l1 = l1.next;
            } else {
                if (root == null) {
                    root = new ListNode(l2.val);
                    temp = root;
                } else {
                    root.next = new ListNode(l2.val);
                    root = root.next;
                }
                l2 = l2.next;
            }
        }
        if (root != null) {
            root.next = l1 == null ? l2 : l1;
        } else {
            root = l1 == null ? l2 : l1;
            temp = root;
        }
        return temp;
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

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            temp.append(node.val);
            if (node.next != null) {
                temp.append("-> ");
            }
            node = node.next;
        }
        return temp.toString();
    }
}
