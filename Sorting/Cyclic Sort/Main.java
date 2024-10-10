import java.util.Arrays;
public class Main{
    public static void main(String[] args) {
        int[] arr={1,5,2,3,4};
        Cyclesort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void Cyclesort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]==arr[correct]){
                i++; 
                }
            else{
                swap(arr,i,correct);
                System.out.println(Arrays.toString(arr));
            }    

        }
    }

    static void swap(int[]arr , int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}