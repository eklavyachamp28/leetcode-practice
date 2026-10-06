package problems;

import java.util.HashMap;
import java.util.Map;

/** LeetCode 1 - Two Sum. O(n) time, O(n) space: one pass with a value->index map. */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = seen.get(target - nums[i]);
            if (j != null) return new int[]{j, i};
            seen.put(nums[i], i);
        }
        throw new IllegalArgumentException("no solution");
    }
}
