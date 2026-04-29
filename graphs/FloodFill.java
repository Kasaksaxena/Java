import java.util.*;

public class FloodFill {

    public  static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int original = image[sr][sc];
        if(original == color) return image;

        dfs(image, sr, sc, original, color);
        return image;
    }

    private static  void dfs(int[][] image, int r, int c, int original, int color) {

        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length)
            return;

        if(image[r][c] != original)
            return;

        image[r][c] = color;

        dfs(image, r + 1, c, original, color);
        dfs(image, r - 1, c, original, color);
        dfs(image, r, c + 1, original, color);
        dfs(image, r, c - 1, original, color);
    }

    public static void main(String[] args) {

        int[][] image = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };

        int[][] result = floodFill(image, 1, 1, 2);

        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
