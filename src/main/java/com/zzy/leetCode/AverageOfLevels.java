package com.zzy.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 曾昭阳
 * @date 2019/9/17 20:11
 */
public class AverageOfLevels {

    private Map<Integer, Double[]> sum = new HashMap<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(7);
        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;
        AverageOfLevels averageOfLevels = new AverageOfLevels();
        List<Double> average = averageOfLevels.averageOfLevels(root);
        average.forEach(data -> System.out.print(data + " "));
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> average = new ArrayList<>();
        ergodic(root, 0);
        sum.forEach((level, record) -> average.add(record[0] / record[1]));
        return average;
    }

    private void ergodic(TreeNode node, int level) {
        if (sum.containsKey(level)) {
            Double[] record = sum.get(level);
            record[0] += (double) node.val;
            record[1] += 1;
            sum.put(level, record);
        } else {
            Double[] record = new Double[2];
            record[0] = (double) node.val;
            record[1] = 1.0;
            sum.put(level, record);
        }
        if (node.left != null) {
            ergodic(node.left, level + 1);
        }
        if (node.right != null) {
            ergodic(node.right, level + 1);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
