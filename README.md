# leetcode-practice

My working solutions to LeetCode problems in Java 21, each with JUnit tests so a solution is only "done" when it passes.

```bash
mvn test
```

| # | Problem | Approach | Complexity |
|---|---|---|---|
| 1 | Two Sum | one-pass hash map | O(n) |
| 3 | Longest Substring Without Repeating Characters | sliding window + last-seen table | O(n) |
| 56 | Merge Intervals | sort by start, sweep | O(n log n) |
| 146 | LRU Cache | hash map + doubly linked list | O(1) per op |
| 207 | Course Schedule | Kahn's topological sort | O(V+E) |
| 347 | Top K Frequent Elements | counting + min-heap of size k | O(n log k) |

Solutions live in `src/main/java/problems`, tests in `src/test/java/problems`. I add problems as I solve them.
