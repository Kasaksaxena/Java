import java.util.PriorityQueue;

public class KthLargestElement {
  
    static int klargestelt(int[] nums , int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums ){
            pq.offer(num);

            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    
}
    public static void main(String[] args){
        int [] arr = {3,2,1,5,6,4};
        int [] arr1 = {3,2,3,1,2,4,5,5,6};
        int k1 = 4;
        int k = 2;
        int result = klargestelt(arr, k);
        int result1 = klargestelt(arr1, k1);

        System.out.println(result);
        System.out.println(result1);

    }
}