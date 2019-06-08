package xyz.ivyxjc.algorithm.leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

public class _1_two_sum_test {

    @Test
    public void test1() {
        _1_two_sum.Solution solution = new _1_two_sum().new Solution();
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] res = solution.twoSum(nums, target);
        int[] expected = {1, 2};
        Assert.assertArrayEquals(expected, res);
    }

    @Test
    public void test2() {
        _1_two_sum.Solution solution = new _1_two_sum().new Solution();
        int[] nums = {1, 2, 3, 4, 6};
        int target = 9;
        int[] res = solution.twoSum(nums, target);
        int[] expected = {2, 4};
        Assert.assertArrayEquals(expected, res);
    }
}
