package com.zzy.leetCode.interview.num_102;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2022/4/13 15:23
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> record = new ArrayList<>();
        record.add(root.val);
        result.add(record);
        List<TreeNode> tmp = new ArrayList<>();
        tmp.add(root);
        while (tmp.size() > 0) {
            record = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();
            for (TreeNode node : tmp) {
                if (node.left != null) {
                    record.add(node.left.val);
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    record.add(node.right.val);
                    nodes.add(node.right);
                }
            }
            if (record.size() != 0) {
                result.add(record);
            }
            tmp = nodes;
        }
        return result;
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
