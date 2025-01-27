import java.util.ArrayList;

public class LinearSMocc{
    public static void main(String[] args) {
        int[] arr={1,3,6,9,8,14,25,36,25,19};
        int target=25;
     int index=0;
     findAllIndex(arr,target,index);
     System.out.println(list);
 
        
    }


    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int[] arr,int target,int index){
        if(index== arr.length){
            return;
        }
        if(arr[index]==target){
            list.add(index);
        }
        findAllIndex(arr,target,index+1);

    }
}