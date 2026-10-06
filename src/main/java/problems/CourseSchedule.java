package problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/** LeetCode 207 - Course Schedule. Kahn's topological sort; a cycle means not all nodes get processed. O(V+E). */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) q.add(i);
        int done = 0;
        while (!q.isEmpty()) {
            int c = q.poll();
            done++;
            for (int next : adj.get(c)) if (--indegree[next] == 0) q.add(next);
        }
        return done == numCourses;
    }
}
