import java.util.*;

public class FloydWarshall {
    static final int INF = 1000000000;

    static void floydwarshall(int[][] dist , int vertices){
        // pick intermediate node
        for(int k =0; k < vertices ; k++){
            // pick source
            for(int i =0; i < vertices ; i++){
                // pick destination
                for(int j =0 ; j < vertices ;j++){
                    // skip if path doesnt exist
                    if(dist[i][k] == INF || dist[k][j] == INF){
                        continue;
                    }
                    if(dist[i][j] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] = dist[k][j];
                    }
                }
            }
        }
    }

        static void printMatrix(int[][] dist) {

        for (int i = 0; i < dist.length; i++) {

            for (int j = 0; j < dist[0].length; j++) {

                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int vertices = 4;

        int[][] dist = {

                {0,   3, 10, INF},
                {INF, 0,  4,  2},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}

        };

        System.out.println("Before Floyd Warshall:\n");

        printMatrix(dist);

        floydwarshall(dist, vertices);

        System.out.println("\nAfter Floyd Warshall:\n");

        printMatrix(dist);
    }

}