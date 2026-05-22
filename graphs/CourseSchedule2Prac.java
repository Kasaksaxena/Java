import java.util.*;

public class CourseSchedule2Prac {

    // Function to find topological order
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        // Step 1: Create indegree array
        int[] indegree = new int[numCourses];

        // Step 2: Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 3: Build graph + calculate indegree
        for (int[] pre : prerequisites) {

            int course = pre[0];
            int prerequisite = pre[1];

            // prerequisite -> course
            adj.get(prerequisite).add(course);

            // increase indegree
            indegree[course]++;
        }

        // Step 4: Queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Add all indegree 0 nodes
        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // Step 5: Store topo order
        int[] topo = new int[numCourses];

        int idx = 0;

        // Step 6: BFS traversal
        while (!q.isEmpty()) {

            int node = q.poll();

            topo[idx++] = node;

            // Visit neighbors
            for (int neigh : adj.get(node)) {

                indegree[neigh]--;

                // If indegree becomes 0
                if (indegree[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }

        // Step 7: Cycle detection
        if (idx != numCourses) {
            return new int[0];
        }

        return topo;
    }

    public static void main(String[] args) {

        int numCourses = 4;

        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        int[] ans = findOrder(numCourses, prerequisites);

        // If cycle exists
        if (ans.length == 0) {

            System.out.println("Cycle detected");
        }
        else {

            System.out.println("Topological Order:");

            for (int course : ans) {
                System.out.print(course + " ");
            }
        }
    }
}