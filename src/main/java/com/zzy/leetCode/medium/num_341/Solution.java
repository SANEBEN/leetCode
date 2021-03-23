package com.zzy.leetCode.medium.num_341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/3/23 11:19
 * <p>
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * <p>
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用next 直到hasNext 返回 false，next返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 * <p>
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用next直到hasNext 返回 false，next返回的元素的顺序应该是: [1,4,6]。
 */
public class Solution {
}

class NestedIterator implements Iterator<Integer> {

    private final List<Integer> integers = new ArrayList<>();

    private int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        add(nestedList);
    }

    @Override
    public Integer next() {
        Integer result = integers.get(index);
        index++;
        return result;
    }

    @Override
    public boolean hasNext() {
        return index <= integers.size();
    }

    public void add(List<NestedInteger> nestedList) {
        for (NestedInteger integer : nestedList) {
            if (integer.isInteger()) {
                integers.add(integer.getInteger());
            } else {
                add(integer.getList());
            }
        }
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}