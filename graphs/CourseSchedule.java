import java.util.*;
import java.util.LinkedList;


public class CourseSchedule {
     public boolean canFinish(int numCourses, int[][] prerequisites) {
        // approach
        // topological -> directed graph -> 

        int[] indegree = new int[numCourses];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int v = pre[0];
            int u = pre[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i ++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int count =0;

        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            
            for(int neigh : adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
        } 
        
        return count == numCourses;
    
}
    public static void main(String[] args) {

        CourseSchedule obj = new CourseSchedule();

        int numCourses = 4;

        int[][] prerequisites = {
                {1, 0},
                {2, 1},
                {3, 2}
        };

        boolean ans = obj.canFinish(numCourses, prerequisites);

        System.out.println("Can Finish? " + ans);
    }


}
