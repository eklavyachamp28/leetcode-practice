package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/** LeetCode 347 - Top K Frequent Elements. Count, then keep a min-heap of size k. O(n log k). */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.merge(n, 1, Integer::sum);
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            heap.offer(e);
            if (heap.size() > k) heap.poll();
        }
        int[] out = new int[heap.size()];
        for (int i = out.length - 1; i >= 0; i--) out[i] = heap.poll().getKey();
        return out;
    }
}
