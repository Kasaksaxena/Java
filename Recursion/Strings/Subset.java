import java.util.ArrayList;
import java.util.List;


public class Subset {
    public static void main(String[] args){
        int[] arr={1,2,3};
        List<List<Integer>> ans= subset(arr);
        for(List<Integer> list: ans){
            System.out.println(list);
        }

    }

    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer= new ArrayList<>();

        outer.add(new ArrayList<>());// adds an empty list

        for (int num : arr) {// iterate over each element
            int n=outer.size();//tells us hown many existing subsets before adding current num
            for (int i = 0; i < n; i++) {//loop through existing subsets
                List<Integer> internal=new ArrayList<>(outer.get(i));// copy existing subset
                internal.add(num);// add current no to this subset
                outer.add(internal);

                
            }
            
        }
        return outer;
    }
}
