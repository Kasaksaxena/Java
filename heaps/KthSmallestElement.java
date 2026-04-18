import java.util.PriorityQueue;
import java.util.Collections;


public class KthSmallestElement{

    public static  int maxheap(int[] arr , int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : arr){
            pq.add(num);
            if(pq.size() > k){
                pq.remove();
            }
        }
        return pq.peek();

    }
    public static void main(String[] args){
        int[] arr = {7,10,4,3,20,15};
        int k = 3;
        int result = maxheap(arr,k);
        System.out.println(result);
    }
}