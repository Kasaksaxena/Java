import java.util.*;

public class NumberOfProvincesDFS{

    static void dfs(int city,
                    int[][] isConnected,
                    boolean[] visited) {

        visited[city] = true;

        for(int neighbor = 0;
            neighbor < isConnected.length;
            neighbor++) {

            // connected and not visited
            if(isConnected[city][neighbor] == 1
               && !visited[neighbor]) {

                dfs(neighbor,
                    isConnected,
                    visited);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;

        for(int city = 0; city < n; city++) {

            if(!visited[city]) {

                provinces++;

                dfs(city,
                    isConnected,
                    visited);
            }
        }

        return provinces;
    }

    public static void main(String[] args) {

        int[][] isConnected = {
            {1,1,0},
            {1,1,0},
            {0,0,1}
        };

        System.out.println(
            findCircleNum(isConnected)
        );
    }
}