import java.util.ArrayList;
import java.util.List;

public class SubsetDuplicates {
   public static void main(String[] args) {
    int[] arr={1,2,2};
    List<List<Integer>> ans= subset(arr);
    for(List<Integer> list: ans){
        System.out.println(list);
    }   
   } 
   static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer= new ArrayList<>();

        outer.add(new ArrayList<>());// adds an empty list
        int start=0;
        int end=0;
        for (int i=0;i<arr.length;i++) {// iterate over each element
            start=0;
            // if current and prev elmt same  s=e+1
            if(i>0 && arr[i]==arr[i-1]){
                start=end+1;
            }
            end=outer.size()-1;
            int n=outer.size();
            for (int j = start; j < n; j++) {//loop through existing subsets
                List<Integer> internal=new ArrayList<>(outer.get(j));// copy existing subset
                internal.add(arr[i]);// add current no to this subset
                outer.add(internal);

                
            }
            
        }
        return outer;
    }
}
