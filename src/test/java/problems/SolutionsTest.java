package problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionsTest {

    @Test
    void twoSum() {
        assertArrayEquals(new int[]{0, 1}, new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, new TwoSum().twoSum(new int[]{3, 2, 4}, 6));
        assertThrows(IllegalArgumentException.class, () -> new TwoSum().twoSum(new int[]{1, 2}, 10));
    }

    @Test
    void lruCache() {
        LruCache c = new LruCache(2);
        c.put(1, 1);
        c.put(2, 2);
        assertEquals(1, c.get(1));
        c.put(3, 3);               // evicts 2
        assertEquals(-1, c.get(2));
        c.put(4, 4);               // evicts 1
        assertEquals(-1, c.get(1));
        assertEquals(3, c.get(3));
        assertEquals(4, c.get(4));
        c.put(3, 30);              // update keeps key, refreshes recency
        assertEquals(30, c.get(3));
    }

    @Test
    void mergeIntervals() {
        int[][] r = new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, r);
        assertArrayEquals(new int[][]{{1, 5}}, new MergeIntervals().merge(new int[][]{{1, 4}, {4, 5}}));
    }

    @Test
    void longestSubstring() {
        LongestSubstringWithoutRepeating s = new LongestSubstringWithoutRepeating();
        assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, s.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
        assertEquals(0, s.lengthOfLongestSubstring(""));
    }

    @Test
    void topKFrequent() {
        int[] r = new TopKFrequent().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        Arrays.sort(r);
        assertArrayEquals(new int[]{1, 2}, r);
    }

    @Test
    void courseSchedule() {
        CourseSchedule cs = new CourseSchedule();
        assertTrue(cs.canFinish(2, new int[][]{{1, 0}}));
        assertFalse(cs.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        assertTrue(cs.canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}}));
    }
}
