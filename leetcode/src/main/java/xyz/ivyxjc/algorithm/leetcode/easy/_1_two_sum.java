package xyz.ivyxjc.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class _1_two_sum {

    /**
     * Time complexity: O(n*lgn)traverse the list only once. Space complexity: O(n)
     */
    class Solution {

        /**
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    res[0] = map.get(nums[i]);
                    res[1] = i;
                }
                map.put(target - nums[i], i);
            }
            return res;
        }
    }

}
