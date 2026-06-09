import java.util.HashMap;

public class LC2316Prac {

    static int[] parent;

    public static long countPairs(int n, int[][] edges) {

        dsu(n);

        for (int[] edge : edges) {

            int a = edge[0];
            int b = edge[1];

            union(a, b);
        }

        // Build Components
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int leader = find(i);

            map.put(leader, map.getOrDefault(leader, 0) + 1);
        }

        System.out.println("Leader -> Size : " + map);

        long result = 0;
        long remaining = n;

        for (int size : map.values()) {

            remaining -= size;

            result += (long) size * remaining;
        }

        return result;
    }

    static void dsu(int n) {

        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {

        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            parent[parentB] = parentA;
        }
    }

    public static void main(String[] args) {

        int n = 10;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},

                {4, 5},
                {5, 6},

                {7, 8}
        };

        long result = countPairs(n, edges);

        System.out.println("Unreachable Pairs = " + result);
    }
}