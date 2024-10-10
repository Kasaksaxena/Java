// Floor: greatest elmt in the array that is less than or equal to target
public class Floor{
    public static void main(String[] args) {
        int[] arr={1,5,8,10,12,15,19,22,28,30,36,40};
        int target=25;
        int ans=floor(arr, target);
        System.out.println(ans);
        
        
    }
    static int  floor(int[] arr,int target){
        int start=0;
        int end=arr.length-1;

        while(start<=end){
           int  mid=start+(end-start)/2;

          if(target<arr[mid]){
            end=mid-1;
          } 
          else if(target>arr[mid]){
            start=mid +1;
          } 
          else{
            return mid;
        } 

        }
    return end;

    }
}