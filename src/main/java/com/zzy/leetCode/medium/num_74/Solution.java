package com.zzy.leetCode.medium.num_74;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/3/30 14:02
 * <p>
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class Solution {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(new Solution().searchMatrix(matrix, 60));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0, right = row * column - 1, mid_row, mid_column, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            mid_row = mid / column;
            mid_column = mid % column;
            int tmp = matrix[mid_row][mid_column];
            if (tmp == target) {
                return true;
            } else if (matrix[mid_row][mid_column] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return false;
    }
}
