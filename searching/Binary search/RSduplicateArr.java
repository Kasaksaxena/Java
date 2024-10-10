public class RSduplicateArr{
    public static void main(String[] args) {
        int[] arr={2,9,2,2,2,2};
        int Ans=Peak(arr);
        System.out.println(Ans);

    }
    static int Peak(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(arr[mid]>arr[mid +1]){
                return mid;
                
            }
            if(arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[start]==arr[mid]&& arr[mid]==arr[end]){
            //remove duplicates

                // check if start is pivot
                if(arr[start]>arr[start]+1){
                    return start;
                }
                else{
                    start++;
                }    
                if(arr[end]<arr[end]-1){
                    return end;
                }
                else{
                    end--;
                }    

                

            }
        
     }
     return-1;
    }
}
