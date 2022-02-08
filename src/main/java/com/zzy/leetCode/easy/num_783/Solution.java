package com.zzy.leetCode.easy.num_783;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/4/13 11:33
 * <p>
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 * <p>
 * 示例：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 */
public class Solution {

    int before = Integer.MIN_VALUE, min = Integer.MIN_VALUE;

    public static void main(String[] args) {

    }


    public int minDiffInBST(TreeNode root) {
        return 0;
    }

    void taverse(TreeNode node) {
        if (node.left != null) {
            taverse(node.left);
        }
        System.out.print(node.val + " ");
        if (node.right != null) {
            taverse(node.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}