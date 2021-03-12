package com.zzy.leetCode.num_2;

import java.util.ArrayList;

/**
 * @author 曾昭阳
 * @date 2020/7/9 11:30
 * 2. 两数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Main {

    public static void main(String[] args) {
        ListNode one = new ListNode(2);
        one.next = new ListNode(4);
        one.next.next = new ListNode(3);

        ListNode two = new ListNode(5);
        two.next = new ListNode(6);
        two.next.next = new ListNode(4);


        ListNode result = new Main().addTwoNumbers(one, two);

        System.out.println(result.toString());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode result = null;
        int carry = 0;//进位
        int remainder;//余数
        ArrayList<Integer> long_ = new ArrayList<>();
        ArrayList<Integer> short_ = new ArrayList<>();
        while (l1 != null) {
            long_.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            short_.add(l2.val);
            l2 = l2.next;
        }
        if (long_.size() < short_.size()) {
            ArrayList<Integer> temp = long_;
            long_ = short_;
            short_ = temp;
        }
        for (int i = 0; i < long_.size(); i++) {
            if (i < short_.size()) {
                remainder = (long_.get(i) + short_.get(i) + carry) % 10;
                carry = (long_.get(i) + short_.get(i) + carry) / 10;
            } else {
                remainder = (long_.get(i) + carry) % 10;
                carry = (long_.get(i) + carry) / 10;
            }
            if (result == null) {
                result = new ListNode(remainder);
                root = result;
            } else {
                result.next = new ListNode(remainder);
                result = result.next;
            }
        }
        if(carry != 0){
            result.next = new ListNode(carry);
        }
        return root;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
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