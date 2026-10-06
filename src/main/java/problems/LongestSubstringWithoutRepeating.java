package problems;

/** LeetCode 3 - Longest Substring Without Repeating Characters. Sliding window with last-seen index table. O(n). */
public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        java.util.Arrays.fill(last, -1);
        int best = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 128 && last[c] >= start) start = last[c] + 1;
            if (c < 128) last[c] = i;
            best = Math.max(best, i - start + 1);
        }
        return best;
    }
}
