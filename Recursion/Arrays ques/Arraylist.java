import java.util.ArrayList;
public class Arraylist{
    public static void main(String[] args){
        int[] arr={4,3,1,4,5,4,9};
        ArrayList<Integer> ans= findAllIndex(arr,4,0, new ArrayList<>());
        System.out.println(findAllIndex2(arr,4,0));

    }

    static ArrayList<Integer> findAllIndex(int[] arr,int target, int index , ArrayList<Integer> list){
      if(index == arr.length){
        return list;
      }
      if(arr[index]== target){
        list.add(index);
      }
      return findAllIndex(arr, target, index+1, list);
    }

    static ArrayList<Integer> findAllIndex2(int[] arr,int target, int index){
      
      ArrayList<Integer> list= new ArrayList<>();
      if(index == arr.length){
        return list;
      }
      // this will contain ans for that function only
      if(arr[index]== target){
        list.add(index);
      }

      ArrayList<Integer> ansFromBelowCalls =findAllIndex2(arr, target, index+1);
      list.addAll(ansFromBelowCalls);

      return list;
    }
}