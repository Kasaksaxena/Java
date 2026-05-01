public class NumberOfProvincesPrac {

    public static int findconnection(int[][] connected){
        int row = connected.length;
        boolean[] visited = new boolean[row];
        int province = 0;


        for(int i = 0 ; i < row ; i ++){
            if(!visited[i]){
                visited[i] = true;
                dfs(connected , visited , i);
                province ++;
            }
        }
        return province;
    }

    public static void dfs(int[][] connected , boolean[] visited , int city){
        int col = connected.length; // symmetric matx row = col

        for(int neighbor = 0 ; neighbor< col ; neighbor++){
            if(connected[city][neighbor] == 1 && !visited[neighbor]){
                visited[neighbor] = true;
                dfs(connected, visited, neighbor);
            }
        }

        
    }
    public static void main(String[] args) {
        int[][] isConnected = {
            {1,0,0},
            {0,1,0},
            {0,0,1}
        };

        System.out.println("Number of Provinces: " + findconnection(isConnected));
    }
    
}
