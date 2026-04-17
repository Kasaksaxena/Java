import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Arrays;

public class TopKFrequent {
   public static int[] topkfreq(int[] arr , int k){
    HashMap<Integer, Integer> map = new HashMap<>();

    for(int num : arr){
        map.put(num , map.getOrDefault(num , 0) + 1);
    }
    // comparing on freq not values
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
    
    for(int num  : map.keySet()){
        pq.offer(num);
        if(pq.size() > k){
            pq.poll();
        }
        
    }
    int[] result =  new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            result[i++]  = pq.poll();
        }
    return  result;


    }
        public static void main(String[] args) {
            int[]  arr = {1,1,1,2,2,3};
            int k = 2;
            int[] ans = topkfreq(arr, k);
            System.out.println( Arrays.toString(ans));
        }
    
}
