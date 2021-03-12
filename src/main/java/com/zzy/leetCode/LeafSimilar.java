package com.zzy.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 曾昭阳
 * @date 2019/9/20 19:49
 */
public class LeafSimilar {


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> record1 = new ArrayList<>();
        List<Integer> record2 = new ArrayList<>();
        ergodic(root1, record1);
        ergodic(root2, record2);
        if (record1.size() != record2.size()) {
            return false;
        } else {
            for (int i = 0; i < record1.size(); i++) {
                if (!record1.get(i).equals(record2.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    private void ergodic(TreeNode node, List<Integer> record) {
        if (node != null) {
            if (node.left != null) {
                ergodic(node.left, record);
            }
            if (node.right != null) {
                ergodic(node.right, record);
            }
            if(node.left == null && node.right == null){
                record.add(node.val);
            }
        }
    }
}
