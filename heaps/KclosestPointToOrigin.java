import java.util.PriorityQueue;
import java.util.Collections;

class Triplets implements Comparable<Triplets> {
    int dist;
    int x;
    int y;

    Triplets(int dist, int x, int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }

    // Min-heap based on distance
    public int compareTo(Triplets t) {
        return Integer.compare(this.dist, t.dist);
    }
}

public class KclosestPointToOrigin {

    public int[][] kclosest(int[][] points, int k) {

        // Max-heap (reverse of min-heap)
        PriorityQueue<Triplets> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            int dist = x * x + y * y;

            pq.add(new Triplets(dist, x, y));

            // keep only k closest
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            Triplets top = pq.remove();
            ans[i][0] = top.x;
            ans[i][1] = top.y;
        }

        return ans;
    }

    // Main method for testing
    public static void main(String[] args) {
        KclosestPointToOrigin obj = new KclosestPointToOrigin();

        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;

        int[][] result = obj.kclosest(points, k);

        for (int[] p : result) {
            System.out.println(p[0] + " " + p[1]);
        }
    }
}