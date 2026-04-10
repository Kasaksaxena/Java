import java.util.ArrayList;

class  Heap<T extends Comparable<T>> {
    private ArrayList<T> list;

    public Heap() {
        list = new ArrayList<>();

    }

    // Insert element 
    public void insert(T value ){
        list.add(value);
        heapifyUp(list.size() - 1);
    }
    // heapify up
    private void heapifyUp(int index){
        while(index >0){
            int parent = (index -1)/2;
            if(list.get(index).compareTo(list.get(parent)) <0){
                swap(index , parent);
                index = parent;

            }else{
                break;
            }
        }
    }
    // swap helper
    private void swap(int i , int j){
        T temp = list.get(i);
        list.set(i , list.get(j));
        list.set(j, temp);
    }

    // remove min elt 
    public T remove(){
        if(list.isEmpty()) return null;

        T removed = list.get(0);
        T last = list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0,last);
            heapifydown(0);
        }
        return removed;

    }

    // heapify down
    private void heapifydown(int index){
        int size = list.size();
        while (true) { 
            int left = 2 * index +1;
            int right = 2 * index +2;
            int smallest = index;

            if(left < size  && list.get(left).compareTo(list.get(smallest)) < 0){
                smallest = left;
            }
            if(right < size  && list.get(right).compareTo(list.get(smallest)) < 0){
                smallest = right;
            }
            if(smallest != index){
                swap(index , smallest);
                index = smallest;
            }else{
                break;
            }


            
        }
    }
    // print heap 
    public void printheap(){
        System.out.println(list);
    }

    // peak (get min)
    public T peek(){
        if(list.isEmpty()) return null;
        return list.get(0);
    }

    }
    



public class RawHeap {
    public static void main(String[] args){
        Heap<Integer> heap = new Heap<>();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(2);

        heap.printheap();

        System.out.println(heap.remove());
        heap.printheap();
        System.out.println(heap.peek());



        

    }    
}
