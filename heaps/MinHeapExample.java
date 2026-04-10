package heaps;
import java.util.PriorityQueue;

public class MinHeapExample {
    //Min heap
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(5);
        pq.add(20);

        System.out.println(pq.peek());
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        // for Max Heap
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        

    }
}
