import java.util.*;

public class CourseSchedule2{
    public  static int[] findOrder(int numCourses, int[][] prerequisites) {
        // input graph -> output topological order or empty list

        int[] inorder = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        //graph making
        for(int i =0; i <numCourses; i++){
            adj.add(new ArrayList<>());

        }

        for(int[] pre : prerequisites){
            int v = pre[0];
            int u = pre[1];
            adj.get(u).add(v);
            inorder[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i =0; i <numCourses; i++){
            if(inorder[i] == 0){
                q.offer(i);
            }
        }
        int idx =0;
        int[] topo = new int[numCourses];

        while(!q.isEmpty()){
            int node = q.poll();
            topo[idx++] = node;

            for(int neigh : adj.get(node)){
                inorder[neigh]--;
                if(inorder[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }
        if(idx != numCourses){
            return new int[0];
        }

        return topo;
        
    }
    public static void main(String[] args){
        int numCourses = 4;
        int[][] prerequisites = {
            {1,0},
            {2,0},
            {3,1},
            {3,2}
        };
        int[] ans = findOrder(numCourses , prerequisites);

        if(ans.length == 0){
            System.out.println("Cycle detected ");
        }else{
            System.out.println("Topological Order :");
            for(int course : ans){
                System.out.print(course + " ");
            }
        }

    }


}