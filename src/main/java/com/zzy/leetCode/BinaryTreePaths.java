package com.zzy.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 曾昭阳
 * @date 2019/9/19 21:25
 */
/*
257
给定一个二叉树，返回所有从根节点到叶子节点的路径。
说明: 叶子节点是指没有子节点的节点。
 */
public class BinaryTreePaths {

    private List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        ergodic(root, "");
        return paths;
    }

    private void ergodic(TreeNode node, String path) {
        if (node != null) {
            if (node.left != null) {
                ergodic(node.left, path + node.val + "->");
            }
            if (node.right != null) {
                ergodic(node.right, path + node.val + "->");
            }
            if (node.right == null && node.left == null) {
                paths.add(path + node.val);
            }
        }
    }
}

