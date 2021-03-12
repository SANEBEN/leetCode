package com.zzy.leetCode;

import java.util.List;

/**
 * @author 曾昭阳
 * @date 2019/9/23 21:43
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return null;
    }

    private void ergodic(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                ergodic(node.left);
            }
            if (node.right != null) {
                ergodic(node.right);
            }
            if (node.right == null && node.left == null) {

            }
        }
    }
}
