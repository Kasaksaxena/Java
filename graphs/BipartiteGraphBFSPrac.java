import java.util.*;
import java.util.LinkedList;

public class BipartiteGraphBFSPrac {

    static boolean isBipartite(ArrayList<ArrayList<Integer>> graph, int V) {

        int[] color = new int[V];
        // 0 = uncolored
        // 1 = red
        // -1 = blue

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {

            // Start BFS if node not colored
            if (color[i] == 0) {

                q.offer(i);
                color[i] = 1;

                while (!q.isEmpty()) {

                    int node = q.poll();

                    for (int neigh : graph.get(node)) {

                        // If neighbor not colored
                        if (color[neigh] == 0) {

                            color[neigh] = -color[node];
                            q.offer(neigh);

                        }
                        // Same color found
                        else if (color[neigh] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected Graph
        graph.get(0).add(1);
        graph.get(0).add(3);

        graph.get(1).add(0);
        graph.get(1).add(2);

        graph.get(2).add(1);
        graph.get(2).add(3);

        graph.get(3).add(0);
        graph.get(3).add(2);

        System.out.println(isBipartite(graph, V));
    }
}

