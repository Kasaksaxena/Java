import java.util.*;

public class DFSIterativeExample {

    static void dfsIterative(int start, List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
            }

            // Push neighbors into stack
            // (reverse order for same output as recursive DFS)
            List<Integer> neighbors = adj.get(node);
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                int neighbor = neighbors.get(i);
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(4);
        adj.get(4).add(2);

        System.out.println("DFS Iterative Traversal:");
        dfsIterative(0, adj, V);
    }
}