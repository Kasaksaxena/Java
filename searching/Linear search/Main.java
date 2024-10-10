import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        int[] arr={25,48,63,46,24,96,12,36,-48,98,100};
        int target=12;
        int Ans=Linearsearch(arr,target);
        System.out.println(Ans);
    }
    static int Linearsearch(int[] arr,int target){
        if(arr.length == 0){
            return -1;
        }

       // returning index 
        /*for(int i=0; i< arr.length;i++){
            int element=arr[i];
            if(element== target){
                return i;
            }

        }*/
      
      // returning elmt itself by enhanced loop
       for(int element:arr){
        if(element==target){
            return element;

        }

       
             
            
       }
        return -1;

    }
}