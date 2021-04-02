package com.zzy.leetCode.medium.num_456;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/3/24 13:49
 * <p>
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * <p>
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(nlogn) 或 O(n) 的解决方案吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 104
 * -109 <= nums[i] <= 109
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(new Solution().find132pattern(nums));
    }

    //最容易想到的暴力算法
    public boolean find132pattern_easy(int[] nums) {
        if (nums.length < 3) {
            return false;
        } else if (nums.length == 3) {
            return nums[0] < nums[2] && nums[2] < nums[1];
        } else {
            int num_1, num_2;
            //第一个数字不可能是数组倒数第三个数往后的书
            for (int i = 0; i < nums.length - 2; i++) {
                num_1 = nums[i];
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (nums[j] > num_1) {
                        num_2 = nums[j];
                        for (int k = j + 1; k < nums.length; k++) {
                            if (nums[k] < num_2 && nums[k] > num_1) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    /**
     * 如果我们从左到右枚举 11 的下标 ii，那么 j, kj,k 的下标范围都是减少的，这样就不利于对它们进行维护。因此我们可以考虑从右到左枚举 ii。
     * 那么我们应该如何维护 j, kj,k 呢？在 132132 模式中，如果 1<21<2 并且 2<32<3，那么根据传递性，1<31<3 也是成立的，那么我们可以使用下面的方法进行维护：
     * 我们使用一种数据结构维护所有遍历过的元素，它们作为 22 的候选元素。每当我们遍历到一个新的元素时，就将其加入数据结构中；
     * 在遍历到一个新的元素的同时，我们可以考虑其是否可以作为 33。如果它作为 33，那么数据结构中所有严格小于它的元素都可以作为 22，我们将这些元素全部从数据结构中移除，并且使用一个变量维护所有被移除的元素的最大值。这些被移除的元素都是可以真正作为 22 的，并且元素的值越大，那么我们之后找到 11 的机会也就越大。
     * 那么这个「数据结构」是什么样的数据结构呢？我们尝试提取出它进行的操作：
     * 它需要支持添加一个元素；
     * 它需要支持移除所有严格小于给定阈值的所有元素；
     * 上面两步操作是「依次进行」的，即我们先用给定的阈值移除元素，再将该阈值加入数据结构中。
     * 这就是「单调栈」。在单调栈中，从栈底到栈顶的元素是严格单调递减的。当给定阈值 xx 时，我们只需要不断地弹出栈顶的元素，直到栈为空或者 xx 严格小于栈顶元素。此时我们再将 xx 入栈，这样就维护了栈的单调性。
     * 因此，我们可以使用单调栈作为维护 22 的数据结构，并给出下面的算法：
     * 我们用单调栈维护所有可以作为 22 的候选元素。初始时，单调栈中只有唯一的元素 \textit{a}[n-1]a[n−1]。我们还需要使用一个变量 \textit{max\_k}max_k 记录所有可以真正作为 22 的元素的最大值；
     * 随后我们从 n-2n−2 开始从右到左枚举元素 a[i]a[i]：
     * 首先我们判断 a[i]a[i] 是否可以作为 1。如果 a[i] < max_k a[i] > max_k，那么它就可以作为 11，我们就找到了一组满足 132132 模式的三元组；
     * 随后我们判断 a[i]a[i] 是否可以作为 3，以此找出哪些可以真正作为 22 的元素。我们将 a[i]a[i] 不断地与单调栈栈顶的元素进行比较，如果 a[i]a[i] 较大，那么栈顶元素可以真正作为 22，将其弹出并更新 \textit{max\_k}max_k；
     * 最后我们将 a[i]a[i] 作为 2 的候选元素放入单调栈中。这里可以进行一个优化，即如果 a[i] \leq \textit{max\_k}a[i]≤max_k，那么我们也没有必要将 a[i]a[i] 放入栈中，因为即使它在未来被弹出，也不会将 \textit{max\_k}max_k 更新为更大的值。
     * 在枚举完所有的元素后，如果仍未找到满足 132132 模式的三元组，那就说明其不存在。
     */
    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        Deque<Integer> queue = new LinkedList<>();
        queue.push(nums[length - 1]);
        int max_k = Integer.MIN_VALUE;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < max_k) {
                return true;
            }
            while (!queue.isEmpty() && nums[i] > queue.peek()) {
                max_k = queue.pop();
            }
            if (nums[i] > max_k) {
                queue.push(nums[i]);
            }
        }
        return false;
    }
}
