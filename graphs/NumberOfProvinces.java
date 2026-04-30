public class NumberOfProvinces {

    public static void dfs(int[][] isConnected, boolean[] visited, int city) {
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
                visited[neighbor] = true;
                dfs(isConnected, visited, neighbor);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(isConnected, visited, i);
                provinces++;
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

        System.out.println("Number of Provinces: " + findCircleNum(isConnected));
    }
}